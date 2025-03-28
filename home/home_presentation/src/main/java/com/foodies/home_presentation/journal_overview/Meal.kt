package com.foodies.home_presentation.journal_overview

import androidx.annotation.DrawableRes
import com.foodies.core.util.UiText
import com.foodies.home_domain.model.MealType

data class Meal(
    val name: UiText,
    @DrawableRes val drawableRes: Int,
    val mealType: MealType,
    val carbs: Int = 0,
    val protein: Int = 0,
    val fat: Int = 0,
    val calories: Int = 0,
    val isExpanded: Boolean = false
)

val defaultMeals = listOf(
    Meal(
        name = UiText.StringResource(com.foodies.core.R.string.breakfast),
        drawableRes = com.foodies.core.R.drawable.ic_breakfast,
        mealType = MealType.Breakfast
    ),
    Meal(
        name = UiText.StringResource(com.foodies.core.R.string.lunch),
        drawableRes = com.foodies.core.R.drawable.ic_lunch,
        mealType = MealType.Lunch
    ),
    Meal(
        name = UiText.StringResource(com.foodies.core.R.string.snacks),
        drawableRes = com.foodies.core.R.drawable.ic_snack,
        mealType = MealType.Snack
    ),
    Meal(
        name = UiText.StringResource(com.foodies.core.R.string.dinner),
        drawableRes = com.foodies.core.R.drawable.ic_dinner,
        mealType = MealType.Dinner
    )
)