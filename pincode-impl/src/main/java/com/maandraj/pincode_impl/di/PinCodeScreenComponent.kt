package com.maandraj.pincode_impl.di

import androidx.annotation.RestrictTo
import com.maandraj.auth_api.feature.api.auth.AuthFeatureApi
import com.maandraj.onboarding_api.feature.api.onboarding.OnBoardingFeatureApi
import com.maandraj.pincode_api.api.PinCodeFeatureApi
import dagger.Component
import kotlin.properties.Delegates

@Component(dependencies = [PinCodeScreenDeps::class])
interface PinCodeScreenComponent {
    @Component.Builder
    interface Builder {

        fun pinCodeScreenDeps(pinCodeScreenDeps: PinCodeScreenDeps): Builder

        fun build(): PinCodeScreenComponent
    }
}

interface PinCodeScreenDeps{
    val onBoardingFeatureApi : OnBoardingFeatureApi
    val authFeatureApi : AuthFeatureApi
}

interface PinCodeDepsProvider{
    @get:RestrictTo(RestrictTo.Scope.LIBRARY)
    val deps: PinCodeScreenDeps
    companion object : PinCodeDepsProvider by PinCodeScreenDepsStore
}

object PinCodeScreenDepsStore : PinCodeDepsProvider{
    override var deps: PinCodeScreenDeps by Delegates.notNull()
}