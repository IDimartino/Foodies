package com.foodies.home_presentation.journal_overview

import com.foodies.home_domain.model.TrackedFood

sealed class JournalOverviewEvent {
    object OnNextDayClick: JournalOverviewEvent()
    object OnPreviousDayClick: JournalOverviewEvent()
    data class OnToggleMealClick(val meal: Meal): JournalOverviewEvent()
    data class OnDeleteTrackedFoodClick(val trackedFood: TrackedFood): JournalOverviewEvent()
}