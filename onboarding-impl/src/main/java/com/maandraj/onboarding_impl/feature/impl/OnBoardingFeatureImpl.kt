package com.maandraj.onboarding_impl.feature.impl

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.maandraj.auth_api.feature.api.auth.AuthFeatureApi
import com.maandraj.onboarding_api.feature.api.onboarding.OnBoardingFeatureApi
import com.maandraj.onboarding_impl.feature.impl.internal.InternalOnBoardingFeatureApi
import com.maandraj.onboarding_impl.feature.screens.OnBoardingScreen
import javax.inject.Inject

class OnBoardingFeatureImpl @Inject constructor(
    private val authFeatureApi: AuthFeatureApi,
) : OnBoardingFeatureApi {

    private val baseRoute = "onBoarding"

    override fun route(): String = baseRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier,
    ) {
        navGraphBuilder.composable(baseRoute) {
            OnBoardingScreen(modifier = modifier,
                navController = navController,
                internalOnBoardingFeatureApi = InternalOnBoardingFeatureApi(authFeatureApi = authFeatureApi))
        }

        InternalOnBoardingFeatureApi(authFeatureApi = authFeatureApi)
            .registerGraph(
                navGraphBuilder = navGraphBuilder,
                navController = navController,
                modifier = modifier
            )
    }

}