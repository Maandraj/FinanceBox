package com.maandraj.pincode_impl.feature.navigation.impl

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.maandraj.core.route.mainPinCodeRoute
import com.maandraj.core.utils.daggerViewModel
import com.maandraj.pincode_api.api.PinCodeFeatureApi
import com.maandraj.pincode_impl.feature.di.pincodeMain.DaggerPinCodeScreenComponent
import com.maandraj.pincode_impl.feature.di.pincodeMain.PinCodeScreenDepsStore
import com.maandraj.pincode_impl.feature.navigation.internal.InternalPinCodeFeatureImpl
import com.maandraj.pincode_impl.feature.screen.main.PinCodeScreen

class PinCodeFeatureImpl (
) : PinCodeFeatureApi {


    override fun route() = mainPinCodeRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier,
    ) {
        val internalPinCodeFeatureImpl = InternalPinCodeFeatureImpl()
        navGraphBuilder.composable(mainPinCodeRoute) {
            val viewModel = daggerViewModel {
                remember {
                    DaggerPinCodeScreenComponent.builder()
                        .pinCodeScreenDeps(PinCodeScreenDepsStore.deps)
                        .build().getViewModel()
                }
            }
            PinCodeScreen(
                navController = navController,
                viewModel = viewModel,
                internalPinCodeFeatureApi = internalPinCodeFeatureImpl,
            )
        }

        internalPinCodeFeatureImpl.registerGraph(
                navGraphBuilder = navGraphBuilder,
                navController = navController,
                modifier = Modifier.padding())


    }
}