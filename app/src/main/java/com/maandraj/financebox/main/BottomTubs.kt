package com.maandraj.financebox.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.maandraj.financebox.R

enum class BottomTabs(
    @StringRes
    val title: Int,
    @DrawableRes
    val icon: Int,
    val route: String
) {
    HOME(R.string.home_tab, R.drawable.ic_launcher_foreground, "auth"),
}