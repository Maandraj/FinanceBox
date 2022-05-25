package com.maandraj.onboarding_impl.feature.di

import androidx.annotation.RestrictTo
import com.maandraj.auth_api.feature.api.auth.AuthFeatureApi
import com.maandraj.onboarding_api.feature.api.onboarding.OnBoardingFeatureApi
import com.maandraj.onboarding_impl.feature.di.finishScreen.FinishScreenModule
import com.maandraj.pincode_api.api.PinCodeFeatureApi
import dagger.Component
import dagger.Module
import javax.inject.Scope
import kotlin.properties.Delegates

@FinishScreenScope
@Component(
    dependencies = [OnBoardingFinishScreenDeps::class],
    modules = [FinishScreenModule::class])
interface FinishScreenComponent {
    @Component.Builder
    interface Builder {

        fun finishScreenDeps(finishScreenDeps: OnBoardingFinishScreenDeps): Builder

        fun build(): FinishScreenComponent
    }
}


interface OnBoardingFinishScreenDeps {
    val pinCodeFeatureApi: PinCodeFeatureApi
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