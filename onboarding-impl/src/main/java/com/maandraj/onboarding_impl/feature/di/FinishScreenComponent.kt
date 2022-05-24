package com.maandraj.onboarding_impl.feature.di

import androidx.annotation.RestrictTo
import com.maandraj.auth_api.feature.api.auth.AuthFeatureApi
import com.maandraj.onboarding_api.feature.api.onboarding.OnBoardingFeatureApi
import dagger.Component
import dagger.Module
import javax.inject.Scope
import kotlin.properties.Delegates

@FinishScreenScope
@Component(
    dependencies = [OnBoardingFinishScreenDeps::class],
    modules = [StartScreenModule::class])
interface FinishScreenComponent{
    @Component.Builder
    interface Builder {

        fun deps(finishScreenDeps:OnBoardingFinishScreenDeps): Builder

        fun build(): FinishScreenComponent
    }
}



interface OnBoardingFinishScreenDeps {
    val authFeatureApi : AuthFeatureApi
    val onBoardingFeatureApi : OnBoardingFeatureApi
}


interface OnBoardingFinishScreenDepsProvider {

    @get:RestrictTo(RestrictTo.Scope.LIBRARY)
    val deps: OnBoardingFinishScreenDeps
    companion object : OnBoardingFinishScreenDepsProvider by OnBoardingFinishScreenDepsStore
}

    object OnBoardingFinishScreenDepsStore : OnBoardingFinishScreenDepsProvider {
    override var deps: OnBoardingFinishScreenDeps by Delegates.notNull()
}



@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class FinishScreenScope