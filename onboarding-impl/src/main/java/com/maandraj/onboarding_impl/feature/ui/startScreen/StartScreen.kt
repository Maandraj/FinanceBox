package com.maandraj.onboarding_impl.feature.ui.startScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.maandraj.core.ui.SimpleButton
import com.maandraj.onboarding_impl.R
import com.maandraj.onboarding_impl.feature.impl.internal.InternalOnBoardingFeatureApi


@Composable
internal fun StartScreen(
                         navController: NavHostController,
                         viewModel: StartScreenViewModel,
                         internalOnBoardingFeatureApi : InternalOnBoardingFeatureApi) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.boarding_contol_guide),
            contentDescription = "Andy Rubin",
            modifier = Modifier
                .height(312.dp)
                .width(312.dp)
                .padding(12.dp)
        )
        Text(
            text = "Gain total control of your money",
            textAlign = TextAlign.Center,
            fontSize = 32.sp,
            modifier = Modifier.padding(12.dp)
        )
        Text(
            text = "Become your own money manager and make every cent count",
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            modifier = Modifier.padding(6.dp)
        )
        SimpleButton(
            text = "Continue",
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(.9f)
                .padding(16.dp),
        ) {
            navController.navigate(internalOnBoardingFeatureApi.screenFinishRoute())
        }

    }
}

