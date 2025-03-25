package com.foodies.home_presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    currentRoute: String,
    onItemSelected: (String) -> Unit
) {
    val items = listOf(
        BottomNavItem.Feed,
        BottomNavItem.Photo,
        BottomNavItem.Tracker,
        BottomNavItem.Profile
    )

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.primary
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 20.dp, top = 5.dp),
                icon = { Icon(item.icon, contentDescription = null) },
                label = { Text(stringResource(item.labelResId)) },
                selected = currentRoute == item.route,
                onClick = { onItemSelected(item.route) },
            )
        }
    }
}