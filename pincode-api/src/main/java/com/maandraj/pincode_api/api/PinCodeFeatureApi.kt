package com.maandraj.pincode_api.api

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.maandraj.feature_api.utils.FeatureApi

interface PinCodeFeatureApi : FeatureApi {
    fun route() : String

}