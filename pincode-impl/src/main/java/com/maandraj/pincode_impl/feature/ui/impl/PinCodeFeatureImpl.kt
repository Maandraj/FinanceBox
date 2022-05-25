package com.maandraj.pincode_impl.feature.ui.impl

import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.maandraj.core.utils.daggerViewModel
import com.maandraj.onboarding_api.feature.api.onboarding.OnBoardingFeatureApi
import com.maandraj.pincode_api.api.PinCodeFeatureApi
import com.maandraj.pincode_impl.di.PinCodeScreenDepsStore
import com.maandraj.pincode_impl.feature.ui.pincode.PinCodeScreen
import javax.inject.Inject

class PinCodeFeatureImpl : PinCodeFeatureApi {
    private val baseRoute = "pinCode"

    override fun route() = baseRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier,
    ) {

        navGraphBuilder.composable(baseRoute) {
            PinCodeScreen(
                navController = navController)
        }
    }
}