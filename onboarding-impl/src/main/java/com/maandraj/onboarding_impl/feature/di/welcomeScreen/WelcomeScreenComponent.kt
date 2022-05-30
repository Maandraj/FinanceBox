package com.maandraj.onboarding_impl.feature.di.welcomeScreen

import androidx.annotation.RestrictTo
import com.maandraj.onboarding_impl.feature.presentation.screen.welcomeScreen.WelcomeScreenViewModel
import com.maandraj.pincode_api.api.PinCodeFeatureApi
import dagger.Component
import javax.inject.Scope
import kotlin.properties.Delegates

@StartScreenScope
@Component(modules = [WelcomeScreenModule::class],
dependencies = [OnBoardingWelcomeScreenDeps::class])
interface OnBoardingWelcomeScreenComponent {


    @Component.Builder
    interface Builder {

        fun welcomeScreenDeps(welcomeScreenDeps: OnBoardingWelcomeScreenDeps): Builder

        fun build(): OnBoardingWelcomeScreenComponent
    }

    fun getViewModel(): WelcomeScreenViewModel
}

interface OnBoardingWelcomeScreenDeps {
    val pinCodeFeatureApi: PinCodeFeatureApi
}


interface OnBoardingWelcomeScreenDepsProvider {

    @get:RestrictTo(RestrictTo.Scope.LIBRARY)
    val deps: OnBoardingWelcomeScreenDeps
    companion object : OnBoardingWelcomeScreenDepsProvider by OnBoardingWelcomeScreenDepsStore
}

object OnBoardingWelcomeScreenDepsStore : OnBoardingWelcomeScreenDepsProvider {
    override var deps: OnBoardingWelcomeScreenDeps by Delegates.notNull()
}






@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class StartScreenScope