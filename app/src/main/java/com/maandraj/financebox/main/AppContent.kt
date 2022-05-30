package com.maandraj.financebox.main


import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.maandraj.core.storage.ConfigPref
import com.maandraj.financebox.main.bars.bottom.BottomBar
import com.maandraj.financebox.main.bars.bottom.BottomTabs
import com.maandraj.financebox.ui.theme.FinanceBoxTheme
import com.maandraj.onboarding_api.feature.api.onboarding.OnBoardingFeatureApi
import com.maandraj.onboarding_impl.feature.navigation.impl.OnBoardingFeatureImpl
import com.maandraj.pincode_api.api.PinCodeFeatureApi
import com.maandraj.pincode_impl.feature.navigation.impl.PinCodeFeatureImpl

@Composable
fun AppContent(
    onBoardingFeatureApi: OnBoardingFeatureApi,
    pinCodeFeatureApi : PinCodeFeatureApi
) {
    ProvideWindowInsets {
        FinanceBoxTheme() {
            val tabs = remember { BottomTabs.values() }
            val navController = rememberNavController()
            Scaffold(
                bottomBar = { BottomBar(navController = navController, tabs) }
            ) { innerPaddingModifier ->
                if (ConfigPref.guideComplete)
                    UnGuideNavGraph(
                        navController = navController,
                        modifier = Modifier.padding(innerPaddingModifier),
                        pinCodeFeatureApi = pinCodeFeatureApi
                    )
                else
                    GuideNavGraph(
                        navController = navController,
                        modifier = Modifier.padding(innerPaddingModifier),
                        onBoardingFeatureApi = onBoardingFeatureApi,
                        pinCodeFeatureApi = pinCodeFeatureApi
                    )
            }
        }
    }
}
@Composable
@Preview
private fun PreviewAppContent(){

   val  onBoardingFeatureApi: OnBoardingFeatureApi = OnBoardingFeatureImpl()
    val pinCodeFeatureApi : PinCodeFeatureApi  = PinCodeFeatureImpl()
    AppContent(onBoardingFeatureApi =onBoardingFeatureApi , pinCodeFeatureApi = pinCodeFeatureApi)
}
