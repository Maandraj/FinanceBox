package com.maandraj.onboarding_impl.feature.impl

import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.maandraj.core.utils.daggerViewModel
import com.maandraj.auth_api.feature.api.auth.AuthFeatureApi
import com.maandraj.onboarding_api.feature.api.onboarding.OnBoardingFeatureApi
import com.maandraj.onboarding_impl.feature.di.DaggerOnBoardingStartScreenComponent
import com.maandraj.onboarding_impl.feature.di.OnBoardingFinishScreenDepsStore
import com.maandraj.onboarding_impl.feature.impl.internal.InternalOnBoardingFeatureApi
import com.maandraj.onboarding_impl.feature.ui.startScreen.StartScreen
import com.maandraj.pincode_api.api.PinCodeFeatureApi
import javax.inject.Inject

class OnBoardingFeatureImpl @Inject constructor() : OnBoardingFeatureApi {


    private val baseRoute = "onBoarding"

    override fun route(): String = baseRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier,
    ) {
        val pinCodeFeatureApi = OnBoardingFinishScreenDepsStore.deps.pinCodeFeatureApi
        val internalOnBoardingFeatureApi =  InternalOnBoardingFeatureApi(pinCodeFeatureApi = pinCodeFeatureApi)
        navGraphBuilder.composable(baseRoute) {
            val viewModel = daggerViewModel {
                remember {
                    DaggerOnBoardingStartScreenComponent.builder().build().getViewModel()
                }
            }
            StartScreen(
                navController = navController,
                viewModel = viewModel,
                internalOnBoardingFeatureApi = internalOnBoardingFeatureApi)
        }

        internalOnBoardingFeatureApi
            .registerGraph(
                navGraphBuilder = navGraphBuilder,
                navController = navController,
                modifier = modifier
            )
    }

}