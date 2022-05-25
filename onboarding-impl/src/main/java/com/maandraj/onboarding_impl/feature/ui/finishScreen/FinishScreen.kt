package com.maandraj.onboarding_impl.feature.ui.finishScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.maandraj.core.ui.SimpleButton
import com.maandraj.core.ui.SimpleSecondButton
import com.maandraj.onboarding_impl.R
import com.maandraj.pincode_api.api.PinCodeFeatureApi


@Composable
internal fun FinishScreen(
    navController: NavHostController,
    pinCodeFeatureApi: PinCodeFeatureApi
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.boarding_money_guide),
            contentDescription = "Money guide",
            modifier = Modifier
                .height(312.dp)
                .width(312.dp)
                .padding(12.dp)
        )
        Text(
            text = "Know where your money goes",
            textAlign = TextAlign.Center,
            fontSize = 32.sp,
            modifier = Modifier.padding(12.dp)
        )
        Text(
            text = "Track your transaction easily, with categories and financial report ",
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            modifier = Modifier.padding(6.dp)
        )
        SimpleButton(
            text = "Finish",
            modifier = Modifier
                .fillMaxWidth(.9f)
                .padding(16.dp),
        ) {
            navController.clearBackStack(pinCodeFeatureApi.route())
            navController.navigate(pinCodeFeatureApi.route())
        }
        SimpleSecondButton(
            text = "Back",
            modifier = Modifier
                .fillMaxWidth(.9f)
                .padding(horizontal = 16.dp, vertical = 5.dp),
        ) {
            navController.navigateUp()
        }
    }
}
