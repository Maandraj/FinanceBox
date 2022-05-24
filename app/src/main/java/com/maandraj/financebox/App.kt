package com.maandraj.financebox

import android.app.Application
import com.chibatching.kotpref.Kotpref
import com.maandraj.financebox.di.AppComponent
import com.maandraj.financebox.di.DaggerAppComponent
import com.maandraj.onboarding_impl.feature.di.OnBoardingFinishScreenDepsProvider
import com.maandraj.onboarding_impl.feature.di.OnBoardingFinishScreenDepsStore

class App : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .build()
    }
    override fun onCreate() {
        super.onCreate()
        OnBoardingFinishScreenDepsStore.deps = appComponent
        Kotpref.init(this)
    }
}