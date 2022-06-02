package com.maandraj.onboarding_impl.feature.presentation.screen.welcomeScreen

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.*
import com.maandraj.core_ui.ui.theme.h2Padding
import com.maandraj.core_ui.ui.theme.h4Padding
import com.maandraj.core_ui.ui.theme.horizontalPadding
import com.maandraj.core_ui.simples.SimpleButton
import com.maandraj.onboarding_impl.feature.util.OnBoardingPage
import com.maandraj.pincode_api.api.PinCodeFeatureApi


@OptIn(ExperimentalPagerApi::class, ExperimentalAnimationApi::class)
@Composable
internal fun WelcomeScreen(
    navController: NavHostController,
    viewModel: WelcomeScreenViewModel,
    pinCodeFeatureApi: PinCodeFeatureApi,
) {
    val pages = listOf(
        OnBoardingPage.ControlGuide,
        OnBoardingPage.MoneyGuide,
    )
    val pagerState = rememberPagerState()

    Column(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            modifier = Modifier.weight(5f),
            count = pages.size,
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) { position ->
            PagerScreen(onBoardingPage = pages[position])
        }
        HorizontalPagerIndicator(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .weight(1f),
            pagerState = pagerState,
            activeColor = MaterialTheme.colors.primary,
        )
        FinishButton(
            modifier = Modifier
                .weight(1f),
            pagerState = pagerState
        ) {
            navController.navigate(pinCodeFeatureApi.route())
        }
    }


}

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
private fun FinishButton(
    modifier: Modifier,
    pagerState: PagerState,
    onClick: () -> Unit,
) {
    val pagesCount = pagerState.pageCount - 1
    val isEnable = pagerState.currentPage == pagesCount

    val fadeOut = fadeOut(animationSpec = tween(110))
    val slideOutHorizontally = slideOutHorizontally(animationSpec = tween(100) )

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = isEnable,
            enter = fadeIn() + slideInHorizontally(),
            exit =  fadeOut + slideOutHorizontally
        ) {

            SimpleButton(
                modifier = Modifier.padding(horizontal = 15.dp),
                text = stringResource(id = com.maandraj.core_ui.R.string.continue_text),
            ) {
                if (isEnable)
                    onClick()
            }
        }
    }

}

@Composable
private fun PagerScreen(onBoardingPage: OnBoardingPage) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = horizontalPadding.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = "Image ${onBoardingPage.title}",
            modifier = Modifier
                .height(312.dp)
                .width(312.dp)
                .padding(12.dp)
        )
        Text(
            text = stringResource(id = onBoardingPage.title),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(vertical = h2Padding.dp)
        )
        Text(
            text = stringResource(id = onBoardingPage.description),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(vertical = h4Padding.dp)
        )
    }
}


@Composable
@Preview(showBackground = true)
private fun ControlGuideScreenPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = OnBoardingPage.ControlGuide)
    }
}

@Composable
@Preview(showBackground = true)
private fun MoneyGuideScreenPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = OnBoardingPage.MoneyGuide)
    }
}



