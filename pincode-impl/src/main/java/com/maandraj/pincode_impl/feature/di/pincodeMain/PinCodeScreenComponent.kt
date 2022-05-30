package com.maandraj.pincode_impl.feature.di.pincodeMain

import androidx.annotation.RestrictTo
import com.maandraj.onboarding_api.feature.api.onboarding.OnBoardingFeatureApi
import com.maandraj.pincode_impl.feature.screen.pincodeMain.PinCodeScreenVM
import dagger.Component
import javax.inject.Scope
import kotlin.properties.Delegates

@Component(dependencies = [PinCodeScreenDeps::class],
    modules = [PinCodeScreenModule::class])
@PinCodeScreenScope
interface PinCodeScreenComponent {
    @Component.Builder
    interface Builder {

        fun pinCodeScreenDeps(pinCodeScreenDeps: PinCodeScreenDeps): Builder

        fun build(): PinCodeScreenComponent
    }

    fun getViewModel(): PinCodeScreenVM

}

interface PinCodeScreenDeps {
    val onBoardingFeatureApi: OnBoardingFeatureApi
}

interface PinCodeDepsProvider {
    @get:RestrictTo(RestrictTo.Scope.LIBRARY)
    val deps: PinCodeScreenDeps

    companion object : PinCodeDepsProvider by PinCodeScreenDepsStore
}

object PinCodeScreenDepsStore : PinCodeDepsProvider {
    override var deps: PinCodeScreenDeps by Delegates.notNull()
}

@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class PinCodeScreenScope