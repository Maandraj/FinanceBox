package com.maandraj.onboarding_impl.feature.util

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.maandraj.onboarding_impl.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    @StringRes
    val title: Int,
    @StringRes
    val description: Int,
) {
    object ControlGuide : OnBoardingPage(
        image = R.drawable.boarding_contol_guide,
        title = R.string.title_control_guide,
        description = R.string.description_control_guide
    )

    object MoneyGuide : OnBoardingPage(
        image = R.drawable.boarding_money_guide,
        title = R.string.titile_money_guide,
        description = R.string.description_money_guide
    )
}
