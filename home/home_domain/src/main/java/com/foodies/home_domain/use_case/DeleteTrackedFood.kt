package com.foodies.home_domain.use_case

import com.foodies.home_domain.model.TrackedFood
import com.foodies.home_domain.repository.JournalRepository

class DeleteTrackedFood(
    private val repository: JournalRepository
) {

    suspend operator fun invoke(trackedFood: TrackedFood) {
        repository.deleteTrackedFood(trackedFood)
    }
}