package com.foodies.app

import android.Manifest
import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.foodies.app.navigation.Route
import com.foodies.home_presentation.camera_view.CameraScreen
import com.foodies.home_presentation.camera_view.PreviewScreen
import com.foodies.home_presentation.feed.FeedScreen
import com.foodies.home_presentation.home.BottomBar
import com.foodies.home_presentation.home.BottomNavItem
import com.foodies.home_presentation.journal_overview.TrackerOverviewScreen
import com.foodies.home_presentation.profile.ProfileScreen
import com.foodies.home_presentation.search.SearchScreen
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import java.net.URLDecoder
import java.net.URLEncoder

@OptIn(ExperimentalCoilApi::class, ExperimentalComposeUiApi::class,
    ExperimentalPermissionsApi::class
)
@Composable
fun HomeNavHost(
    navController: NavHostController
) {

    val scaffoldState = rememberScaffoldState()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: BottomNavItem.Feed.route

    val cameraPermissionState = rememberPermissionState(
        Manifest.permission.CAMERA
    )
    var isPermissionGranted by remember { mutableStateOf(cameraPermissionState.status.isGranted) }

    LaunchedEffect(cameraPermissionState.status) {
        isPermissionGranted = cameraPermissionState.status.isGranted
        if (cameraPermissionState.status.isGranted) {
            // Permission granted, open the camera
        } else if (cameraPermissionState.status.shouldShowRationale){
            Log.d("permission", "should show rationale")
        } else {
            Log.d("permission", "permission denied")
        }
    }

    Scaffold(
        bottomBar = {
            BottomBar(
                currentRoute = currentRoute,
                onItemSelected = { route ->
                    if (route == BottomNavItem.Photo.route) {
                        if (cameraPermissionState.status.isGranted) {
                            // Permission already granted, open the camera
                            Log.d("permission", "already granted")
                            navController.navigate(BottomNavItem.Photo.route)
                        } else {
                            // Permission not granted, request it
                            cameraPermissionState.launchPermissionRequest()
                        }
                    } else {
                        navController.navigate(route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                                inclusive = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Feed.route,
            Modifier.padding(innerPadding)
        ) {
            composable(
                route = Route.SEARCH + "/{mealName}/{dayOfMonth}/{month}/{year}",
                arguments = listOf(
                    navArgument("mealName") {
                        type = NavType.StringType
                    },
                    navArgument("dayOfMonth") {
                        type = NavType.IntType
                    },
                    navArgument("month") {
                        type = NavType.IntType
                    },
                    navArgument("year") {
                        type = NavType.IntType
                    },
                )
            ) {
                val mealName = it.arguments?.getString("mealName")!!
                val dayOfMonth = it.arguments?.getInt("dayOfMonth")!!
                val month = it.arguments?.getInt("month")!!
                val year = it.arguments?.getInt("year")!!
                SearchScreen(
                    scaffoldState = scaffoldState,
                    mealName = mealName,
                    dayOfMonth = dayOfMonth,
                    month = month,
                    year = year,
                    onNavigateUp = {
                        navController.navigateUp()
                    }
                )
            }

            composable(BottomNavItem.Feed.route) {
                FeedScreen(innerPadding = innerPadding)
            }
            composable(BottomNavItem.Photo.route) {
                if (isPermissionGranted){
                    CameraScreen(onPhotoTaken = { filePath ->
                        val encodedFilePath = URLEncoder.encode(filePath, "UTF-8")
                        navController.navigate("preview/$encodedFilePath")
                    })
                }
            }
            composable("preview/{filePath}") { backStackEntry ->
                val encodedFilePath = backStackEntry.arguments?.getString("filePath") ?: ""
                val filePath = URLDecoder.decode(encodedFilePath, "UTF-8")
                PreviewScreen(filePath, {
                    navController.navigate(BottomNavItem.Feed.route)
                })
            }
            composable(BottomNavItem.Tracker.route) {
                TrackerOverviewScreen(onNavigateToSearch = { mealName, day, month, year ->
                    navController.navigate(
                        Route.SEARCH + "/$mealName" +
                                "/$day" +
                                "/$month" +
                                "/$year"
                    )
                })
            }
            composable(BottomNavItem.Profile.route) { ProfileScreen() }
        }
    }
}