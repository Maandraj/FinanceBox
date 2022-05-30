package com.maandraj.pincode_impl.feature.navigation.internal

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.Modifier
import com.maandraj.feature_api.utils.FeatureApi

interface InternalPinCodeFeatureApi : FeatureApi {
    fun screenPinCodeRoute(pincode:String): String
}