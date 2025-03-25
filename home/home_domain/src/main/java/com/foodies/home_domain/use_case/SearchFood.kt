package com.foodies.home_domain.use_case

import com.foodies.home_domain.model.TrackableFood
import com.foodies.home_domain.repository.JournalRepository

class SearchFood(
    private val repository: JournalRepository
) {

    suspend operator fun invoke(
        query: String,
        page: Int = 1,
        pageSize: Int = 40
    ): Result<List<TrackableFood>> {
        if(query.isBlank()) {
            return Result.success(emptyList())
        }
        return repository.searchFood(query.trim(), page, pageSize)
    }
}