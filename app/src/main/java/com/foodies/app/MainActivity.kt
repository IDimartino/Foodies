package com.foodies.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.foodies.app.ui.theme.FoodiesTheme
import com.foodies.core.domain.preferences.Preferences
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@ExperimentalComposeUiApi
@ExperimentalCoilApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            var shouldShowOnboarding by remember { mutableStateOf( preferences.loadShouldShowOnboarding()) }

            FoodiesTheme {
                val scaffoldState = rememberScaffoldState()

                val onboardingNavController = rememberNavController()
                val homeNavController = rememberNavController()

                if (shouldShowOnboarding) {
                    OnboardingNavHost(
                        navController = onboardingNavController,
                        onOnboardingComplete = { shouldShowOnboarding = false }
                    )
                } else {
                    HomeNavHost(navController = homeNavController)
                }
            }
        }
    }
}