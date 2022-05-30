package com.maandraj.financebox.di

import com.maandraj.onboarding_api.feature.api.onboarding.OnBoardingFeatureApi
import com.maandraj.onboarding_impl.feature.navigation.impl.OnBoardingFeatureImpl
import com.maandraj.pincode_api.api.PinCodeFeatureApi
import com.maandraj.pincode_impl.feature.navigation.impl.PinCodeFeatureImpl
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    @AppScope
    fun provideOnBoardingFeatureApi(): OnBoardingFeatureApi = OnBoardingFeatureImpl()

    @Provides
    @AppScope
    fun providePinCodeFeatureApi(): PinCodeFeatureApi = PinCodeFeatureImpl()

    @Provides
    @AppScope
    fun provideMoshi(): Moshi = Moshi.Builder().build()

}