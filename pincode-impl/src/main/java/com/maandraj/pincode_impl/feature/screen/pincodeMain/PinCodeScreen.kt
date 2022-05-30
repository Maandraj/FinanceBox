package com.maandraj.pincode_impl.feature.screen.pincodeMain

import android.util.Log
import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.maandraj.core_ui.ui.theme.h4Padding
import com.maandraj.core_ui.ui.theme.horizontalPadding
import com.maandraj.core_ui.ui.theme.topPadding
import com.maandraj.core_ui.ui.simples.AppBarBack
import com.maandraj.core_ui.ui.simples.CodeView
import com.maandraj.core_ui.ui.simples.SimpleButton
import com.maandraj.pincode_impl.R
import com.maandraj.pincode_impl.feature.navigation.internal.InternalPinCodeFeatureApi
import com.maandraj.pincode_impl.feature.navigation.internal.InternalPinCodeFeatureImpl

private const val PIN_LENGTH = 5

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PinCodeScreen(
    navController: NavHostController,
    viewModel: PinCodeScreenVM,
    internalPinCodeFeatureApi: InternalPinCodeFeatureApi,
) {

    val focusManager = LocalFocusManager.current
    val (pincode, setPincode) = rememberSaveable { mutableStateOf("") }
    val (isError, setIsError) = rememberSaveable { mutableStateOf(false) }
    Scaffold(

        topBar = {
            AppBarBack(
                title = stringResource(R.string.pin_code_text),
                focusManager = focusManager,
                navController = navController
            )
        }, content = {

            Column(modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                Column(modifier = Modifier
                    .wrapContentSize()
                    .padding(horizontal = horizontalPadding.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Text(text = stringResource(R.string.enter_your_pin_code),
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier
                    )

                    CodeView(codeLength = PIN_LENGTH,
                        isError = isError,
                        whenClickCell = {
                            setIsError(false)
                        },
                        whenFull = { pin ->
                            Log.i(TAG, "PinCode - $pin")
                            setPincode(pin)
                        })

                    Text(
                        text = stringResource(R.string.pin_code_information),
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(vertical = h4Padding.dp)
                    )

                }


                    SimpleButton(
                        text = stringResource(id = com.maandraj.core.R.string.continue_text),
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth(.9f)
                            .padding(top = topPadding.dp),
                    ) {
                        if (pincode.length < PIN_LENGTH) {
                            setIsError(true)
                            return@SimpleButton
                        }
                        navController.navigate(internalPinCodeFeatureApi.screenPinCodeRoute(pincode))
                    }
                }


        })

}

@Composable
@Preview(showBackground = true)
private fun ContentPinCodePreview() {
    PinCodeScreen(
        navController = NavHostController(LocalContext.current),
        viewModel = PinCodeScreenVM(),
        internalPinCodeFeatureApi =
        InternalPinCodeFeatureImpl(),
    )
}


private const val TAG = "PIN-CODE"


