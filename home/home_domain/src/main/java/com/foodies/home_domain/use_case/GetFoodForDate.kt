package com.foodies.home_domain.use_case

import com.foodies.home_domain.model.TrackedFood
import com.foodies.home_domain.repository.JournalRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class GetFoodsForDate(
    private val repository: JournalRepository
) {

    operator fun invoke(date: LocalDate): Flow<List<TrackedFood>> {
        return repository.getFoodsForDate(date)
    }
}