package com.maandraj.pincode_impl.feature.navigation.internal

import androidx.compose.ui.Modifier
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.maandraj.pincode_impl.feature.screen.pincodeRepeat.PinCodeRepeatScreen


internal class InternalPinCodeFeatureImpl() : InternalPinCodeFeatureApi {

    private val pincodeParameter = "pin"
    private val scenarioPinCode = "pincode/scenarioPincode"
    private val repeatPinCodeScreen = "pincode/repeat"


    override fun screenPinCodeRoute(pincode: String) = "$repeatPinCodeScreen/${pincode}"


    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier,
    ) {

        navGraphBuilder.navigation(
            route = scenarioPinCode,
            startDestination = "$repeatPinCodeScreen/{$pincodeParameter}",
        ) {

            composable(route = "$repeatPinCodeScreen/{$pincodeParameter}",
                arguments = listOf(navArgument(pincodeParameter) { type = NavType.StringType })
            ) { backStackEntry ->
                val arguments = backStackEntry.arguments
                val argument = arguments?.getString(pincodeParameter)
                PinCodeRepeatScreen(navController = navController,
                    modifier = modifier,
                    pincode = argument)
            }
        }
    }
}