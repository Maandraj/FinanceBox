package com.maandraj.core_ui.ui.simples

import androidx.compose.animation.Animatable
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.maandraj.core_ui.ui.theme.defButtonShape
import kotlinx.coroutines.delay

private const val TAG = "CodeView"
private const val CELL_HEIGHT = 60
private const val CELL_WIDTH = 60

/**
 *  Генерация ячеек для ввода кода
 *  isError - вызов ошибки
 *  whenFull - вызов метода когда все поле заполнены
 *  whenClickCell - вызов метода  когда юзер нажал на поле
 */
@ExperimentalComposeUiApi
@Composable
fun CodeView(
    codeLength: Int,
    isError: Boolean = false,
    whenFull: (code: String) -> Unit,
    whenClickCell: () -> Unit,
) {
    val (editValue, setEditValue) = remember { mutableStateOf("") }
    val (isFinal, setIsFinal) = remember { mutableStateOf(false) }
    val originalOffset = IntOffset(x = 0, y = 0)
    val focusRequester = remember { FocusRequester() }
    val keyboard = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        modifier = Modifier
            .size(0.dp)
            .focusRequester(focusRequester),
        value = editValue,
        isError = true,
        onValueChange = {
            if (!it.isDigitsOnly())
                return@OutlinedTextField
            if (it.length <= codeLength) {
                whenClickCell()
                setEditValue(it)
            }
            if (it.length >= codeLength) {
                setEditValue(it)
                setIsFinal(true)
                whenFull(it)
                keyboard?.hide()
            }

        },
        shape = RoundedCornerShape(defButtonShape.dp),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number
        )
    )
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        (0 until codeLength).map { index ->
            val modifier = Modifier

            val sumValue: Float = 1 / codeLength.toFloat()
            val centerValue: Float = 1 / codeLength.toFloat()
            val divValue: Float = index / codeLength.toFloat()
            if (1.0f - divValue == sumValue) {
                //TODO ЛОГИКА ДЛЯ АНИМАЦИИ В ЦЕНТР
            }

            val targetOffset = IntOffset(x = 60, y = 0)
            val offset by animateIntOffsetAsState(targetValue = if (isFinal) targetOffset else originalOffset,
                tween(durationMillis = 1000, easing = FastOutSlowInEasing))

            CodeCell(
                modifier = modifier
                    .offset(offset.x.dp * (codeLength - index), offset.y.dp)
                    .weight(1f)
                    .size(height = CELL_HEIGHT.dp,
                        width = CELL_WIDTH.dp),
                value = editValue.getOrNull(index)?.toString() ?: "",
                isCursorVisible = editValue.length == index,
                isError = isError,
                onClick = {
                    whenClickCell()
                    focusRequester.requestFocus()
                    keyboard?.show()
                }
            )
            Spacer(modifier = Modifier.size(12.dp))
        }
    }

}

@Composable
private fun CodeCell(
    modifier: Modifier,
    value: String,
    isError: Boolean,
    isCursorVisible: Boolean = false,
    onClick: () -> Unit,
) {
    val (cursorSymbol, setCursorSymbol) = remember { mutableStateOf("") }
    val colorDef =
        MaterialTheme.colors.onSurface.copy(alpha = ButtonDefaults.OutlinedBorderOpacity)
    val colorError = MaterialTheme.colors.error
    val animateColor = remember { Animatable(colorDef) }

    if (isError)
        AnimatedColor(animatableColor = animateColor,
            targetColor = colorError,
            durationMillis = 100)
    else if (!isError) {
        AnimatedColor(animatableColor = animateColor,
            targetColor = colorDef,
            durationMillis = 500)
    }

    LaunchedEffect(key1 = cursorSymbol, isCursorVisible) {
        if (isCursorVisible) {

            delay(150)
            setCursorSymbol("_")

        }
    }


    OutlinedButton(onClick = onClick,
        modifier = modifier
            .border(1.dp, color = animateColor.asState().value)
            .background(Color.Transparent)
    ) {

        Box(Modifier.fillMaxSize()) {
            Text(
                text = if (isCursorVisible) cursorSymbol else value,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.align(Alignment.Center)
            )
        }

    }

}

@Composable
private fun AnimatedColor(
    animatableColor: Animatable<Color, AnimationVector4D>,
    targetColor: Color,
    durationMillis: Int,
    delayMills: Int = 10,
) {
    LaunchedEffect(animatableColor) {
        animatableColor.animateTo(
            targetValue = targetColor,
            animationSpec = repeatable(
                animation = tween(
                    durationMillis = durationMillis,
                    easing = FastOutSlowInEasing,
                    delayMillis = delayMills
                ),
                iterations = 1
            )
        )
    }
}