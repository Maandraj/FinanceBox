package com.maandraj.onboarding_impl.feature.di

import com.maandraj.auth_api.feature.api.auth.AuthFeatureApi
import com.maandraj.onboarding_impl.feature.impl.internal.InternalOnBoardingFeatureApi
import com.maandraj.onboarding_impl.feature.ui.startScreen.StartScreenViewModel
import com.maandraj.pincode_api.api.PinCodeFeatureApi
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


}


@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class StartScreenScope