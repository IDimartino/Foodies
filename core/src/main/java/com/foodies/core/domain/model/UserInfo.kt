package com.foodies.core.domain.model

data class UserInfo(
    val name: String,
    val gender: Gender,
    val age: Int,
    val weight: Float,
    val height: Int,
    val activityLevel: ActivityLevel,
    val goalType: GoalType,
    val carbRatio: Float,
    val proteinRatio: Float,
    val fatRatio: Float
)