package com.foodies.home_data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.foodies.home_data.local.entity.JournalFoodEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface JournalDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrackedFood(trackedFoodEntity: JournalFoodEntity)

    @Delete
    suspend fun deleteTrackedFood(trackedFoodEntity: JournalFoodEntity)

    @Query(
        """
            SELECT *
            FROM journalfoodentity
            WHERE dayOfMonth = :day AND month = :month AND year = :year
        """
    )
    fun getFoodsForDate(day: Int, month: Int, year: Int): Flow<List<JournalFoodEntity>>
}