package com.maandraj.onboarding_impl.feature.di

import com.maandraj.auth_api.feature.api.auth.AuthFeatureApi
import com.maandraj.onboarding_impl.feature.impl.internal.InternalOnBoardingFeatureApi
import com.maandraj.onboarding_impl.feature.screens.StartScreenViewModel
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@StartScreenScope
@Component(modules = [StartScreenModule::class])
interface OnBoardingStartScreenComponent {

    @Component.Builder
    interface Builder {
        fun build(): OnBoardingStartScreenComponent
    }

    fun getViewModel(): StartScreenViewModel
}


@Module
internal class StartScreenModule {
    @Provides
    @StartScreenScope
    fun provideViewModel(): StartScreenViewModel = StartScreenViewModel()

    @Provides
    @StartScreenScope
    fun provideInternalOnBoardingFeatureApi(authFeatureApi: AuthFeatureApi): InternalOnBoardingFeatureApi =
        InternalOnBoardingFeatureApi(authFeatureApi = authFeatureApi)
}


@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class StartScreenScope