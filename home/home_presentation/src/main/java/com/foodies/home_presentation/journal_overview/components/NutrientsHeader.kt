package com.foodies.home_presentation.journal_overview.components

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.foodies.coreui.CarbColor
import com.foodies.coreui.FatColor
import com.foodies.coreui.LocalSpacing
import com.foodies.coreui.ProteinColor
import com.foodies.home_presentation.components.UnitDisplay
import com.foodies.home_presentation.journal_overview.JournalOverviewState

@Composable
fun NutrientsHeader(
    state: JournalOverviewState,
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current
    val animatedCalorieCount = animateIntAsState(
        targetValue = state.totalCalories
    )
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(
                    bottomStart = 50.dp,
                    bottomEnd = 50.dp
                )
            )
            .background(MaterialTheme.colors.primary)
            .padding(
                horizontal = spacing.spaceLarge,
                vertical = spacing.spaceExtraLarge
            )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            UnitDisplay(
                amount = animatedCalorieCount.value,
                unit = stringResource(id = com.foodies.core.R.string.kcal),
                amountColor = MaterialTheme.colors.onPrimary,
                amountTextSize = 40.sp,
                unitColor = MaterialTheme.colors.onPrimary,
                modifier = Modifier.align(Alignment.Bottom)
            )
            Column {
                Text(
                    text = stringResource(id = com.foodies.core.R.string.your_goal),
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.onPrimary
                )
                UnitDisplay(
                    amount = state.caloriesGoal,
                    unit = stringResource(id = com.foodies.core.R.string.kcal),
                    amountColor = MaterialTheme.colors.onPrimary,
                    amountTextSize = 40.sp,
                    unitColor = MaterialTheme.colors.onPrimary,
                )
            }
        }
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        NutrientsBar(
            carbs = state.totalCarbs,
            protein = state.totalProtein,
            fat = state.totalFat,
            calories = state.totalCalories,
            calorieGoal = state.caloriesGoal,
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
        )
        Spacer(modifier = Modifier.height(spacing.spaceLarge))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            NutrientBarInfo(
                value = state.totalCarbs,
                goal = state.carbsGoal,
                name = stringResource(id = com.foodies.core.R.string.carbs),
                color = CarbColor,
                modifier = Modifier.size(90.dp)
            )
            NutrientBarInfo(
                value = state.totalProtein,
                goal = state.proteinGoal,
                name = stringResource(id = com.foodies.core.R.string.protein),
                color = ProteinColor,
                modifier = Modifier.size(90.dp)
            )
            NutrientBarInfo(
                value = state.totalFat,
                goal = state.fatGoal,
                name = stringResource(id = com.foodies.core.R.string.fat),
                color = FatColor,
                modifier = Modifier.size(90.dp)
            )
        }
    }
}