package com.maandraj.financebox.di

import com.maandraj.auth.impl.AuthFeatureImpl
import com.maandraj.auth_api.feature.api.auth.AuthFeatureApi
import com.maandraj.onboarding_api.feature.api.onboarding.OnBoardingFeatureApi
import com.maandraj.onboarding_impl.feature.impl.OnBoardingFeatureImpl
import com.maandraj.pincode_api.api.PinCodeFeatureApi
import com.maandraj.pincode_impl.feature.ui.impl.PinCodeFeatureImpl
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    @AppScope
    fun onBoardingFeatureApiProvide(): OnBoardingFeatureApi = OnBoardingFeatureImpl()

    @Provides
    @AppScope
    fun pinCodeFeatureApiProvide(): PinCodeFeatureApi = PinCodeFeatureImpl()

    @Provides
    @AppScope
    fun authFeatureApiProvide(): AuthFeatureApi = AuthFeatureImpl()


}