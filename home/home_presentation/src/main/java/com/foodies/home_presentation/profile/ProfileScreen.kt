package com.foodies.home_presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.foodies.core.domain.model.UserInfo
import com.foodies.coreui.LocalSpacing
import com.foodies.home_presentation.profile.components.EmptyProfilePicture

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val userInfo by viewModel.userInfo.collectAsStateWithLifecycle()
    ProfileContent(userInfo)
}

@Composable
fun ProfileContent(userInfo: UserInfo?) {
    val spacing = LocalSpacing.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceLarge),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (userInfo != null) {
            Column() {
                EmptyProfilePicture(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.Gray.copy(alpha = 0.3f))
                )
                Spacer(modifier = Modifier.height(spacing.spaceSmall))
                Text(
                    text = userInfo.name,
                    style = MaterialTheme.typography.body2,
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            ProfileCard(userInfo)
        } else {
            Text(text = "No User Data", textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun ProfileCard(userInfo: UserInfo) {
    val spacing = LocalSpacing.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colors.primary)
            .padding(spacing.spaceMedium)
    ) {
        Text(
            text = "About me",
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        UserInfoRow(title = "Age", value = userInfo.age.toString())
        UserInfoRow(title = "Gender", value = userInfo.gender.name)
        UserInfoRow(title = "Height", value = "${userInfo.height} cm")
        UserInfoRow(title = "Weight", value = "${userInfo.weight} kg")
        UserInfoRow(title = "Goal", value = userInfo.goalType.name)
        UserInfoRow(title = "Activity", value = userInfo.activityLevel.name)
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        Text(
            text = "Nutrient Ratio",
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        UserInfoRow(title = "Carbs", value = "${(userInfo.carbRatio*100).toInt()}%")
        UserInfoRow(title = "Protein", value = "${(userInfo.proteinRatio*100).toInt()}%")
        UserInfoRow(title = "Fat", value = "${(userInfo.fatRatio*100).toInt()}%")
    }
}

@Composable
fun UserInfoRow(title: String, value: String) {
    val spacing = LocalSpacing.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(spacing.spaceSmall)
    ) {
        Text(
            text = title,
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        Text(
            text = value,
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.body2,
            fontSize = 16.sp
        )
    }
}