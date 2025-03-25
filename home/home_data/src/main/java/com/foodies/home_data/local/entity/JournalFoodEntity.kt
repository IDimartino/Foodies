package com.foodies.home_data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class JournalFoodEntity(
    val name: String,
    val carbs: Int,
    val protein: Int,
    val fat: Int,
    val imageUrl: String?,
    val type: String,
    val amount: Int,
    val dayOfMonth: Int,
    val month: Int,
    val year: Int,
    val calories: Int,
    @PrimaryKey val id: Int? = null
)