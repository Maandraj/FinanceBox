package com.maandraj.financebox.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.maandraj.feature_api.utils.register
import com.maandraj.onboarding_api.feature.api.onboarding.OnBoardingFeatureApi
import com.maandraj.pincode_api.api.PinCodeFeatureApi


@Composable
fun GuideNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    onBoardingFeatureApi: OnBoardingFeatureApi,
    pinCodeFeatureApi: PinCodeFeatureApi,
) {
    NavHost(
        navController = navController,
        startDestination = onBoardingFeatureApi.route()
    ) {
        register(
            onBoardingFeatureApi,
            navController = navController,
            modifier = modifier
        )

        register(
            pinCodeFeatureApi,
            navController = navController,
            modifier = modifier
        )
    }
}

@Composable
fun UnGuideNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    pinCodeFeatureApi: PinCodeFeatureApi
    ) {
    NavHost(
        navController = navController,
        startDestination = pinCodeFeatureApi.route()

    ) {
        register(
            pinCodeFeatureApi,
            navController = navController,
            modifier = modifier
        )
    }
}