package com.uagr.kmp.course.presentation.ui.register.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.uagr.kmp.course.presentation.component.buton.ButtonCustom
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.field.TextFieldCustom
import com.uagr.kmp.course.presentation.component.field.TextFieldPassword
import com.uagr.kmp.course.presentation.component.text.TextBigBold
import com.uagr.kmp.course.presentation.component.text.TextNormal
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import course.shared.generated.resources.Res
import course.shared.generated.resources.ic_back_arrow_2
import course.shared.generated.resources.ic_visibility_off
import course.shared.generated.resources.ic_visibility_on
import course.shared.generated.resources.login_description
import course.shared.generated.resources.login_title
import course.shared.generated.resources.register_button
import course.shared.generated.resources.register_confirm_password
import course.shared.generated.resources.register_email
import course.shared.generated.resources.register_name
import course.shared.generated.resources.register_password
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun RegisterContainer(
    name : String = "",
    nameError : String = "",
    onNameChange : (String) -> Unit = {},
    email : String = "",
    emailError : String = "",
    onEmailChange: (String) -> Unit = {},
    password: String = "",
    passwordError : String = "",
    onPasswordChange: (String) -> Unit = {},
    passwordVisible: Boolean = false,
    onPasswordVisibleChange: (Boolean) -> Unit = {},
    confirmPassword : String = "",
    confirmPasswordError : String = "",
    onConfirmPasswordChange: (String) -> Unit = {},
    confirmPasswordVisible: Boolean = false,
    onConfirmPasswordVisibleChange: (Boolean) -> Unit = {},
    onRegisterClick: () -> Unit = {},
    onBackClick: () -> Unit = {},
) {
    val scrollState = rememberScrollState()
    val focusManager = LocalFocusManager.current
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = Dimens.padding16)
            .verticalScroll(state = scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = Dimens.height8))
        {
            Icon(
                modifier = Modifier.size(Dimens.height20)
                    .clickable{
                        onBackClick()
                    },
                painter = painterResource(Res.drawable.ic_back_arrow_2),
                contentDescription = null,
                tint = AppTheme.colors.backgrounds.black
            )
        }
        
        Spacer(modifier = Modifier.fillMaxWidth().weight(1f))
        TextBigBold(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            fontSize = Dimens.textSizeBig,
            color = AppTheme.colors.text.blue,
            text = stringResource(Res.string.login_title),
        )
        TextNormal(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            fontSize = Dimens.textSizeNormal,
            color = AppTheme.colors.text.gray,
            text = stringResource(Res.string.login_description),
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height32))
        TextFieldCustom(
            value = name,
            errorText = nameError,
            onValueChange = onNameChange,
            labelColor = AppTheme.colors.text.black,
            label = stringResource(Res.string.register_name),
            placeholderColor = AppTheme.colors.text.black,
            placeholder = "",
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height12))
        TextFieldCustom(
            value = email,
            errorText = emailError,
            onValueChange = onEmailChange,
            labelColor = AppTheme.colors.text.black,
            label = stringResource(Res.string.register_email),
            placeholderColor = AppTheme.colors.text.black,
            placeholder = "",
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next,
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height12))
        TextFieldPassword(
            password = password,
            onPasswordChange = onPasswordChange,
            errorText = passwordError,
            passwordVisible = passwordVisible,
            onPasswordVisibleChange = onPasswordVisibleChange,
            labelColor = AppTheme.colors.text.black,
            label = stringResource(Res.string.register_password),
            placeholderColor = AppTheme.colors.text.black,
            placeholder = "",
            trailingIconActive = Res.drawable.ic_visibility_on,
            trailingIconInActive = Res.drawable.ic_visibility_off,
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Next,
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height12))
        TextFieldPassword(
            password = confirmPassword,
            onPasswordChange = onConfirmPasswordChange,
            errorText = confirmPasswordError,
            passwordVisible = confirmPasswordVisible,
            onPasswordVisibleChange = onConfirmPasswordVisibleChange,
            labelColor = AppTheme.colors.text.black,
            label = stringResource(Res.string.register_confirm_password),
            placeholderColor = AppTheme.colors.text.black,
            placeholder = "",
            trailingIconActive = Res.drawable.ic_visibility_on,
            trailingIconInActive = Res.drawable.ic_visibility_off,
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done,
            keyboardActions = KeyboardActions(
                onAny = {
                    focusManager.clearFocus()
                },
            ),
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height100))
        ButtonCustom(
            modifier = Modifier.height(Dimens.height50),
            onClick = onRegisterClick,
            backgroundButton = AppTheme.colors.primary,
            textColor = AppTheme.colors.backgrounds.white,
            text = stringResource(Res.string.register_button),
        )
        Spacer(modifier = Modifier.fillMaxWidth().weight(2f))
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterContainerPreview() {
    SafeScreenContainerTest {
        RegisterContainer()
    }
}