package com.foodies.app

import android.annotation.SuppressLint
import androidx.compose.compiler.plugins.kotlin.EmptyFunctionMetrics.composable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.foodies.app.navigation.Route
import com.foodies.onboarding_presentation.activity.ActivityScreen
import com.foodies.onboarding_presentation.age.AgeScreen
import com.foodies.onboarding_presentation.gender.GenderScreen
import com.foodies.onboarding_presentation.goal.GoalScreen
import com.foodies.onboarding_presentation.height.HeightScreen
import com.foodies.onboarding_presentation.name.NameScreen
import com.foodies.onboarding_presentation.nutrient_goal.NutrientGoalScreen
import com.foodies.onboarding_presentation.weight.WeightScreen
import com.foodies.onboarding_presentation.welcome.WelcomeScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun OnboardingNavHost(
    navController: NavHostController,
    onOnboardingComplete: () -> Unit
) {

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
    ) { innerPadding ->
        NavHost(navController = navController, startDestination = "welcome") {
            composable(Route.WELCOME) {
                WelcomeScreen(onNextClick = {
                    navController.navigate(Route.NAME)
                })
            }
            composable(Route.NAME) {
                NameScreen(
                    scaffoldState = scaffoldState,
                    onNextClick = {
                        navController.navigate(Route.GENDER)
                    })
            }
            composable(Route.GENDER) {
                GenderScreen(onNextClick = {
                    navController.navigate(Route.AGE)
                })
            }
            composable(Route.AGE) {
                AgeScreen(
                    scaffoldState = scaffoldState,
                    onNextClick = {
                        navController.navigate(Route.HEIGHT)
                    })
            }
            composable(Route.HEIGHT) {
                HeightScreen(
                    scaffoldState = scaffoldState,
                    onNextClick = {
                        navController.navigate(Route.WEIGHT)
                    })
            }
            composable(Route.WEIGHT) {
                WeightScreen(
                    scaffoldState = scaffoldState,
                    onNextClick = {
                        navController.navigate(Route.ACTIVITY)
                    })
            }
            composable(Route.ACTIVITY) {
                ActivityScreen(onNextClick = {
                    navController.navigate(Route.GOAL)
                })
            }
            composable(Route.GOAL) {
                GoalScreen(onNextClick = {
                    navController.navigate(Route.NUTRIENT_GOAL)
                })
            }
            composable(Route.NUTRIENT_GOAL) {
                NutrientGoalScreen(
                    scaffoldState = scaffoldState,
                    onNextClick = {
                        onOnboardingComplete()
                    })
            }
        }
    }
}