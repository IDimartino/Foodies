package com.foodies.home_data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.foodies.home_data.local.entity.JournalFoodEntity

@Database(
    entities = [JournalFoodEntity::class],
    version = 1
)
abstract class JournalDatabase: RoomDatabase() {

    abstract val dao: JournalDao
}