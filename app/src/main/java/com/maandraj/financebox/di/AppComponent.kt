package com.maandraj.financebox.di

import android.app.Application
import com.maandraj.financebox.MainActivity
import com.maandraj.onboarding_api.feature.api.onboarding.OnBoardingFeatureApi
import com.maandraj.onboarding_impl.feature.di.welcomeScreen.OnBoardingWelcomeScreenDeps
import com.maandraj.pincode_api.api.PinCodeFeatureApi
import com.maandraj.pincode_impl.feature.di.pincodeMain.PinCodeScreenDeps
import com.maandraj.pincode_impl.feature.di.pincodeRepeat.PinCodeRepeatScreenDeps
import dagger.BindsInstance
import dagger.Component
import javax.inject.Scope

@Component( modules = [AppModule::class])
@AppScope
interface AppComponent : OnBoardingWelcomeScreenDeps, PinCodeScreenDeps, PinCodeRepeatScreenDeps {

    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override val pinCodeFeatureApi: PinCodeFeatureApi
    override val onBoardingFeatureApi: OnBoardingFeatureApi
}


@Scope
annotation class AppScope