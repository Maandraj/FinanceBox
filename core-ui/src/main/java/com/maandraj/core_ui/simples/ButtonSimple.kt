package com.maandraj.core_ui.simples

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.maandraj.core_ui.ui.theme.mainColor
import com.maandraj.core_ui.ui.theme.secondaryColor


@Composable
fun SimpleButton(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = mainColor,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = color)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.body1,
            color = Color.White,
            modifier = Modifier
                .padding(8.dp),
        )
    }
}

@Composable
fun SimpleSecondButton(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = secondaryColor,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = color)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.body1,
            color = mainColor,
            modifier = Modifier
                .padding(8.dp),
        )
    }
}