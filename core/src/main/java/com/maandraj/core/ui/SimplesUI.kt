package com.maandraj.core.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maandraj.core.ui.theme.mainColor
import com.maandraj.core.ui.theme.secondaryColor

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
        Text(text = text, modifier = Modifier.padding(5.dp), fontSize = 18.sp, color = Color.White)
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
        Text(text = text, modifier = Modifier.padding(5.dp), fontSize = 18.sp, color = mainColor)
    }
}