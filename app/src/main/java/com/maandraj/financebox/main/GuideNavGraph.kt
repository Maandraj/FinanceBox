package com.maandraj.financebox.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.maandraj.auth_api.feature.api.auth.AuthFeatureApi
import com.maandraj.feature_api.register
import com.maandraj.onboarding_api.feature.api.onboarding.OnBoardingFeatureApi


@Composable
fun GuideNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    onBoardingFeatureApi: OnBoardingFeatureApi,
    authFeatureApi: AuthFeatureApi,
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
            authFeatureApi,
            navController = navController,
            modifier = modifier
        )
    }
}

@Composable
fun UnGuideNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    authFeatureApi: AuthFeatureApi,

    ) {
    NavHost(
        navController = navController,
        startDestination = authFeatureApi.route()

    ) {

        register(
            authFeatureApi,
            navController = navController,
            modifier = modifier
        )
    }
}