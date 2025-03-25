package com.foodies.home_domain.di

import com.foodies.core.domain.preferences.Preferences
import com.foodies.home_domain.repository.JournalRepository
import com.foodies.home_domain.use_case.CalculateMealNutrients
import com.foodies.home_domain.use_case.DeleteTrackedFood
import com.foodies.home_domain.use_case.GetFoodsForDate
import com.foodies.home_domain.use_case.SearchFood
import com.foodies.home_domain.use_case.JournalFood
import com.foodies.home_domain.use_case.JournalUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object HomeDomainModule {

    @ViewModelScoped
    @Provides
    fun provideTrackerUseCases(
        repository: JournalRepository,
        preferences: Preferences
    ): JournalUseCases {
        return JournalUseCases(
            trackFood = JournalFood(repository),
            searchFood = SearchFood(repository),
            getFoodsForDate = GetFoodsForDate(repository),
            deleteTrackedFood = DeleteTrackedFood(repository),
            calculateMealNutrients = CalculateMealNutrients(preferences)
        )
    }
}