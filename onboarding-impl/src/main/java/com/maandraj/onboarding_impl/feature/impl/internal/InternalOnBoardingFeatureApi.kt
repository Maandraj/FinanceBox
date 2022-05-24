package com.maandraj.onboarding_impl.feature.impl.internal

import androidx.compose.ui.Modifier
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.maandraj.auth_api.feature.api.auth.AuthFeatureApi
import com.maandraj.feature_api.utils.FeatureApi
import com.maandraj.onboarding_impl.feature.screens.OnBoardingScreenFinish
import javax.inject.Inject


internal class InternalOnBoardingFeatureApi(
    private val authFeatureApi: AuthFeatureApi,
) : FeatureApi {
    private val scenarioStartFinishRoute = "onBoarding/scenarioStartFinishRoute"
    private val screenStartRoute = "onBoarding/start"
    private val screenFinishRoute = "onBoarding/finish"

    fun screenFinishRoute() = screenFinishRoute


    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier,
    ) {
        navGraphBuilder.navigation(
            route = scenarioStartFinishRoute,
            startDestination = screenStartRoute
        ) {

            composable(route = screenFinishRoute) {
                OnBoardingScreenFinish(
                    navController = navController,
                    authFeatureApi = authFeatureApi)
            }
        }
    }
}