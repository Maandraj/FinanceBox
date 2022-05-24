package com.maandraj.onboarding_api.feature.api.onboarding

import com.maandraj.feature_api.utils.FeatureApi

interface OnBoardingFeatureApi : FeatureApi {
    fun route() : String
}