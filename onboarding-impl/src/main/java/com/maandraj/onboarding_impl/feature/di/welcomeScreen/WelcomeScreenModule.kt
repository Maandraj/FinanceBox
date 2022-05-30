package com.maandraj.onboarding_impl.feature.di.welcomeScreen

import com.maandraj.onboarding_impl.feature.presentation.screen.welcomeScreen.WelcomeScreenViewModel
import dagger.Module
import dagger.Provides

@Module
internal class WelcomeScreenModule {
    @Provides
    @StartScreenScope
    fun provideViewModel(): WelcomeScreenViewModel = WelcomeScreenViewModel()
}