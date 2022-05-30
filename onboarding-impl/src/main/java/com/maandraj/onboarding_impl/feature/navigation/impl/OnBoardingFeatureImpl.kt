package com.maandraj.onboarding_impl.feature.navigation.impl

import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.maandraj.core.route.onBoardingRoute
import com.maandraj.core.utils.daggerViewModel
import com.maandraj.onboarding_api.feature.api.onboarding.OnBoardingFeatureApi
import com.maandraj.onboarding_impl.feature.di.welcomeScreen.DaggerOnBoardingWelcomeScreenComponent
import com.maandraj.onboarding_impl.feature.di.welcomeScreen.OnBoardingWelcomeScreenDepsProvider
import com.maandraj.onboarding_impl.feature.presentation.screen.welcomeScreen.WelcomeScreen

class OnBoardingFeatureImpl : OnBoardingFeatureApi {



    override fun route(): String = onBoardingRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier,
    ) {
        val deps = OnBoardingWelcomeScreenDepsProvider.deps
        val pinCodeFeatureApi = deps.pinCodeFeatureApi
        navGraphBuilder.composable(onBoardingRoute)
         {
            val viewModel = daggerViewModel {
                remember {
                    DaggerOnBoardingWelcomeScreenComponent.builder().welcomeScreenDeps(deps)
                        .build()
                        .getViewModel()
                }
            }
            WelcomeScreen(
                navController = navController,
                viewModel = viewModel,
                pinCodeFeatureApi = pinCodeFeatureApi)
        }

    }

}