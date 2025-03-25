package com.foodies.home_data.repository

import com.foodies.home_data.local.JournalDao
import com.foodies.home_data.mapper.toTrackableFood
import com.foodies.home_data.mapper.toTrackedFood
import com.foodies.home_data.mapper.toTrackedFoodEntity
import com.foodies.home_data.remote.OpenFoodApi
import com.foodies.home_domain.model.TrackableFood
import com.foodies.home_domain.model.TrackedFood
import com.foodies.home_domain.repository.JournalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate

class JournalRepositoryImpl(
    private val dao: JournalDao,
    private val api: OpenFoodApi
): JournalRepository {

    override suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<TrackableFood>> {
        return try {
            val searchDto = api.searchFood(
                query = query,
                page = page,
                pageSize = pageSize
            )
            Result.success(
                searchDto.products
                    .filter {
                        val calculatedCalories =
                            it.nutriments.carbohydrates100g * 4f +
                                    it.nutriments.proteins100g * 4f +
                                    it.nutriments.fat100g * 9f
                        val lowerBound = calculatedCalories * 0.99f
                        val upperBound = calculatedCalories * 1.01f
                        it.nutriments.energyKcal100g in (lowerBound..upperBound)
                    }
                    .mapNotNull { it.toTrackableFood() }
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun insertTrackedFood(food: TrackedFood) {
        dao.insertTrackedFood(food.toTrackedFoodEntity())
    }

    override suspend fun deleteTrackedFood(food: TrackedFood) {
        dao.deleteTrackedFood(food.toTrackedFoodEntity())
    }

    override fun getFoodsForDate(localDate: LocalDate): Flow<List<TrackedFood>> {
        return dao.getFoodsForDate(
            day = localDate.dayOfMonth,
            month = localDate.monthValue,
            year = localDate.year
        ).map { entities ->
            entities.map { it.toTrackedFood() }
        }
    }
}