package com.foodies.home_domain.use_case

import com.foodies.home_domain.model.MealType
import com.foodies.home_domain.model.TrackableFood
import com.foodies.home_domain.model.TrackedFood
import com.foodies.home_domain.repository.JournalRepository
import java.time.LocalDate
import kotlin.math.roundToInt

class JournalFood(
    private val repository: JournalRepository
) {

    suspend operator fun invoke(
        food: TrackableFood,
        amount: Int,
        mealType: MealType,
        date: LocalDate
    ) {
        repository.insertTrackedFood(
            TrackedFood(
                name = food.name,
                carbs = ((food.carbsPer100g / 100f) * amount).roundToInt(),
                protein = ((food.proteinPer100g / 100f) * amount).roundToInt(),
                fat = ((food.fatPer100g / 100f) * amount).roundToInt(),
                calories = ((food.caloriesPer100g / 100f) * amount).roundToInt(),
                imageUrl = food.imageUrl,
                mealType = mealType,
                amount = amount,
                date = date,
            )
        )
    }
}