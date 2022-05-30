package com.maandraj.financebox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.maandraj.financebox.main.AppContent
import com.maandraj.financebox.ui.theme.FinanceBoxTheme
import com.maandraj.onboarding_api.feature.api.onboarding.OnBoardingFeatureApi
import com.maandraj.pincode_api.api.PinCodeFeatureApi
import javax.inject.Inject

class MainActivity : ComponentActivity() {


    @Inject
    lateinit var onBoardingFeatureApi: OnBoardingFeatureApi

    @Inject
    lateinit var pinCodeFeatureApi: PinCodeFeatureApi

    private val appComponent by lazy {
        (application as App).appComponent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, true)
        appComponent.inject(this)
        onBoardingFeatureApi = appComponent.onBoardingFeatureApi
        pinCodeFeatureApi = appComponent.pinCodeFeatureApi

        setContent {
            FinanceBoxTheme {
                AppContent(onBoardingFeatureApi = onBoardingFeatureApi,
                    pinCodeFeatureApi = pinCodeFeatureApi)
            }
        }
    }
}

