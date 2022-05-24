package com.maandraj.financebox.di

import com.maandraj.auth.impl.AuthFeatureImpl
import com.maandraj.auth_api.feature.api.auth.AuthFeatureApi
import com.maandraj.onboarding_api.feature.api.onboarding.OnBoardingFeatureApi
import com.maandraj.onboarding_impl.feature.impl.OnBoardingFeatureImpl
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    @AppScope
    fun onBoardingFeatureApi(authFeatureApi: AuthFeatureApi) : OnBoardingFeatureApi = OnBoardingFeatureImpl(authFeatureApi = authFeatureApi)

    @Provides
    @AppScope
    fun authFeatureApi() : AuthFeatureApi = AuthFeatureImpl()

}