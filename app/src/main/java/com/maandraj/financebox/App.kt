package com.maandraj.financebox

import android.app.Application
import com.chibatching.kotpref.Kotpref
import com.maandraj.financebox.di.AppComponent
import com.maandraj.financebox.di.DaggerAppComponent
import com.maandraj.onboarding_impl.feature.di.welcomeScreen.OnBoardingWelcomeScreenDepsStore
import com.maandraj.pincode_impl.feature.di.pincodeMain.PinCodeScreenDepsStore
import com.maandraj.pincode_impl.feature.di.pincodeRepeat.PinCodeRepeatScreenDepsStore

class App : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .build()
    }
    override fun onCreate() {
        super.onCreate()
        OnBoardingWelcomeScreenDepsStore.deps = appComponent
        PinCodeScreenDepsStore.deps = appComponent
        PinCodeRepeatScreenDepsStore.deps = appComponent
        Kotpref.init(this)
    }
}