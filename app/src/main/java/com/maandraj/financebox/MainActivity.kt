package com.maandraj.financebox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.maandraj.auth.impl.AuthFeatureImpl
import com.maandraj.auth_api.feature.api.auth.AuthFeatureApi
import com.maandraj.financebox.main.AppContent
import com.maandraj.financebox.ui.theme.FinanceBoxTheme
import com.maandraj.onboarding_api.feature.api.onboarding.OnBoardingFeatureApi
import com.maandraj.onboarding_impl.feature.impl.OnBoardingFeatureImpl
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var authFeatureApi: AuthFeatureApi

    @Inject
    lateinit var onBoardingFeatureApi: OnBoardingFeatureApi
    private val appComponent by lazy {
        (application as App).appComponent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, true)

        appComponent.inject(this)
        authFeatureApi = appComponent.authFeatureApi
        onBoardingFeatureApi = appComponent.onBoardingFeatureApi

        setContent {
            FinanceBoxTheme {
                AppContent(onBoardingFeatureApi = onBoardingFeatureApi,
                    authFeatureApi = authFeatureApi)
            }
        }
    }
}

