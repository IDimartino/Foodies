package com.foodies.home_domain.use_case

data class JournalUseCases(
    val trackFood: JournalFood,
    val searchFood: SearchFood,
    val getFoodsForDate: GetFoodsForDate,
    val deleteTrackedFood: DeleteTrackedFood,
    val calculateMealNutrients: CalculateMealNutrients
)