package com.maandraj.financebox

import android.app.Application
import com.chibatching.kotpref.Kotpref
import com.maandraj.financebox.di.AppComponent
import com.maandraj.financebox.di.DaggerAppComponent
import com.maandraj.onboarding_impl.feature.di.OnBoardingFinishScreenDepsStore
import com.maandraj.pincode_impl.di.PinCodeScreenDeps
import com.maandraj.pincode_impl.di.PinCodeScreenDepsStore

class App : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .build()
    }
    override fun onCreate() {
        super.onCreate()
        OnBoardingFinishScreenDepsStore.deps = appComponent
        PinCodeScreenDepsStore.deps = appComponent
        Kotpref.init(this)
    }
}