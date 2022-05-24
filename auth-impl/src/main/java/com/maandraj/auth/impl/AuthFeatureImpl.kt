package com.maandraj.auth.impl

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.maandraj.auth.presentation.AuthScreen
import com.maandraj.auth_api.feature.api.auth.AuthFeatureApi


class AuthFeatureImpl : AuthFeatureApi {
    private val baseRoute = "auth"

    override fun route() = baseRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {

        navGraphBuilder.composable(baseRoute) {
            AuthScreen(modifier = modifier, navController = navController)
        }

    }

}