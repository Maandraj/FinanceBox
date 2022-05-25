package com.maandraj.financebox.di

import android.app.Application
import com.maandraj.auth_api.feature.api.auth.AuthFeatureApi
import com.maandraj.financebox.MainActivity
import com.maandraj.onboarding_api.feature.api.onboarding.OnBoardingFeatureApi
import com.maandraj.onboarding_impl.feature.di.OnBoardingFinishScreenDeps
import com.maandraj.pincode_api.api.PinCodeFeatureApi
import com.maandraj.pincode_impl.di.PinCodeScreenDeps
import dagger.BindsInstance
import dagger.Component
import javax.inject.Scope

@Component( modules = [AppModule::class])
@AppScope
interface AppComponent : OnBoardingFinishScreenDeps, PinCodeScreenDeps{

    fun inject(activity: MainActivity)

    override val pinCodeFeatureApi: PinCodeFeatureApi
    override val onBoardingFeatureApi: OnBoardingFeatureApi
    override val authFeatureApi: AuthFeatureApi


    // override val pinCodeFeatureApi: PinCodeFeatureApi

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}


@Scope
annotation class AppScope