package com.maandraj.pincode_api.api

import com.maandraj.feature_api.utils.FeatureApi

interface PinCodeFeatureApi : FeatureApi {
    fun route() : String
}