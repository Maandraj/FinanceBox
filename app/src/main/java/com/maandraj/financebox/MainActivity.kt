package com.maandraj.financebox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.maandraj.auth_api.feature.api.auth.AuthFeatureApi
import com.maandraj.financebox.ui.main.AppContent
import com.maandraj.financebox.ui.theme.FinanceBoxTheme
import com.maandraj.onboarding_api.feature.api.onboarding.OnBoardingFeatureApi
import com.maandraj.pincode_api.api.PinCodeFeatureApi
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var authFeatureApi: AuthFeatureApi

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
        authFeatureApi = appComponent.authFeatureApi
        onBoardingFeatureApi = appComponent.onBoardingFeatureApi
        pinCodeFeatureApi = appComponent.pinCodeFeatureApi

        setContent {
            FinanceBoxTheme {
                AppContent(onBoardingFeatureApi = onBoardingFeatureApi,
                    authFeatureApi = authFeatureApi,
                    pinCodeFeatureApi = pinCodeFeatureApi)
            }
        }
    }
}

