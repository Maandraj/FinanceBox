package com.maandraj.core_ui.simples

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AppBarBack(
    title: String,
    focusManager: FocusManager,
    navController: NavController,
    navigationIcon: ImageVector? = Icons.Filled.ArrowBack,
) {
    TopAppBar(
        title = {
            Text(text = title)
        },
        navigationIcon = {
            if (navigationIcon != null) {
                IconButton(onClick = {
                    focusManager.clearFocus()
                    navController.navigateUp()
                }) {
                    Icon(navigationIcon, "ButtonBackIcon")
                }
            }
        },
        backgroundColor = MaterialTheme.colors.background,
        elevation = 10.dp
    )
}