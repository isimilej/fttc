package com.playground.fttc.ui.login

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.playground.fttc.R
import com.playground.fttc.data.user.FakeUserRepository
import com.playground.fttc.ui.component.FttcAlertDialog
import com.playground.fttc.ui.component.FttcTextField
import com.playground.fttc.ui.component.PrimaryFttcButton
import com.playground.fttc.ui.component.WindowSizeClass
import com.playground.fttc.ui.home.HomeActivity
import com.playground.fttc.ui.theme.FttcStyle
import com.playground.fttc.ui.theme.FttcTheme

private enum class LoginFormType {
    Compact,
    InCard
}

private fun getLoginFormType(windowSizeClass: WindowSizeClass): LoginFormType {
    if (windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact
        || windowSizeClass.heightSizeClass == WindowHeightSizeClass.Compact) {
        return LoginFormType.Compact
    } else {
        return LoginFormType.InCard
    }
}

@Composable
fun LoginScreen(windowSizeClass: WindowSizeClass, viewModel: LoginViewModel) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val formType = getLoginFormType(windowSizeClass)

    Box(
        Modifier
            .fillMaxSize()
            .background(FttcStyle.color.Background),
        contentAlignment = Alignment.Center,
    ) {
        if (formType == LoginFormType.Compact) {
            LoginForm(
                userId = viewModel.userId,
                onChangeUserId = { viewModel.updateUserId(it) },
                password = viewModel.password,
                onChangePassword = { viewModel.updatePassword(it) },
                onLogin = {
                    viewModel.login()
                },
                modifier = Modifier.width(360.dp)
            )
        } else {
            Card(
                shape = RoundedCornerShape(32.dp),
                colors = CardDefaults.cardColors(containerColor = FttcStyle.color.White),
                elevation = CardDefaults.outlinedCardElevation(defaultElevation = 16.dp),
            ) {
                LoginForm(
                    userId = viewModel.userId,
                    onChangeUserId = { viewModel.updateUserId(it) },
                    password = viewModel.password,
                    onChangePassword = { viewModel.updatePassword(it) },
                    onLogin = { viewModel.login() },
                    modifier = Modifier
                        .width(460.dp)
                        .padding(40.dp)
                )
            }
        }

        //FidoAuthNoticeBottomSheet()
    }

    when (val state = uiState) {
        is LoginUiState.Success -> {
            val context = LocalContext.current
            context.startActivity(Intent(context, HomeActivity::class.java))
        }
        is LoginUiState.RequestFidoAuth -> {
            FidoAuthNoticeBottomSheet()
        }
        is LoginUiState.Error -> {
            val errorMessage = when (state) {
                is LoginUiState.Error.EmptyUserId -> {
                    stringResource(id = R.string.input_user_id)
                }
                is LoginUiState.Error.EmptyPassword -> {
                    stringResource(id = R.string.input_password)
                }
                is LoginUiState.Error.NotMatched -> {
                    stringResource(id = R.string.check_user_id_and_password)
                }
                is LoginUiState.Error.NotFoundUser -> {
                    stringResource(id = R.string.not_found_user)
                }
            }
            FttcAlertDialog(errorMessage) {
                viewModel.ready()
            }
        }
        else -> {
            // ignored
        }
    }
}

@Composable
fun LoginForm(
    userId: String,
    onChangeUserId: (String) -> Unit,
    password: String,
    onChangePassword: (String) -> Unit,
    onLogin: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoginTypeTabRow()
        Spacer(Modifier.height(24.dp))
        FttcTextField(
            value = userId,
            onValueChange = onChangeUserId,
            modifier = Modifier.fillMaxWidth(),
            hint = "아이디"
        )
        Spacer(Modifier.height(12.dp))
        FttcTextField(
            value = password,
            onValueChange = onChangePassword,
            modifier = Modifier.fillMaxWidth(),
            hint = "비밀번호",
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Spacer(Modifier.height(24.dp))
        PrimaryFttcButton(
            text = stringResource(id = R.string.login),
            onClick = onLogin,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )
    }
}

@Composable
private fun LoginTypeTabRow() {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        containerColor = Color.Transparent,
        indicator = { tabPositions ->
            if (selectedTabIndex < tabPositions.size) {
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                    height = 2.dp,
                    color = FttcStyle.color.Brand
                )
            }
        }
    ) {
        listOf("MOTP 입력", "생체인증(FIDO)").forEachIndexed { index, tab ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = { selectedTabIndex = index },
                modifier = Modifier.height(48.dp)
            ) {
                Text(
                    text = tab,
                    style = FttcStyle.typo.T3SemiBold.copy(
                        color = if (selectedTabIndex == index) FttcStyle.color.Brand else FttcStyle.color.Grey600
                    )
                )
            }
        }
    }
}

@Preview(device = Devices.TABLET)
@Composable
fun PreviewHomeScreenOnTablet() {
    FttcTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LoginScreen(
                WindowSizeClass(),
                viewModel(factory = LoginViewModel.provideFactory(repository = FakeUserRepository()))
            )
        }
    }
}

@Preview(device = Devices.FOLDABLE)
@Composable
fun PreviewHomeScreenOnFoldable() {
    FttcTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LoginScreen(
                WindowSizeClass(),
                viewModel(factory = LoginViewModel.provideFactory(repository = FakeUserRepository()))
            )
        }
    }
}

@Preview(name = "Portrait Mode", showBackground = true, device = Devices.PHONE)
@Preview(name = "Landscape Mode", showBackground = true, device = Devices.AUTOMOTIVE_1024p, widthDp = 890, heightDp = 410)
@Composable
fun PreviewHomeScreenOnPhoneLandscape() {
    FttcTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            LoginScreen(
                WindowSizeClass(),
                viewModel(factory = LoginViewModel.provideFactory(repository = FakeUserRepository()))
            )
        }
    }
}
