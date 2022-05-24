package com.maandraj.auth_api.feature.api.auth

import com.maandraj.feature_api.utils.FeatureApi

/**
 * @Author: Maandraj on 21.05.2022
 */
interface AuthFeatureApi : FeatureApi {
    fun route() : String
}