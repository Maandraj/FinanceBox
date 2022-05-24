package com.maandraj.dependencyprovider.di

import com.maandraj.onboarding_api.feature.api.onboarding.OnBoardingFeatureApi
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(modules = [DependencyModule::class])
interface DependencyComponent {
}

@Module
class DependencyModule {



}

