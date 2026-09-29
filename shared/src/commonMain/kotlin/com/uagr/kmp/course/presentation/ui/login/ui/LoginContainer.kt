/*
 * LoginContainer.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.login.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.uagr.kmp.course.presentation.component.buton.ButtonCustom
import com.uagr.kmp.course.presentation.component.buton.SingleChoiceSegmentedButton
import com.uagr.kmp.course.presentation.component.buton.TextButton
import com.uagr.kmp.course.presentation.component.card.SimpleCard
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.field.TextFieldCustom
import com.uagr.kmp.course.presentation.component.field.TextFieldPassword
import com.uagr.kmp.course.presentation.component.text.TextBigBold
import com.uagr.kmp.course.presentation.component.text.TextNormal
import com.uagr.kmp.course.presentation.component.text.TextNormalBold
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import course.shared.generated.resources.Res
import course.shared.generated.resources.ic_mini_chart_2
import course.shared.generated.resources.ic_visibility_off
import course.shared.generated.resources.ic_visibility_on
import course.shared.generated.resources.login_amount
import course.shared.generated.resources.login_balance
import course.shared.generated.resources.login_button
import course.shared.generated.resources.login_create_account
import course.shared.generated.resources.login_description
import course.shared.generated.resources.login_email
import course.shared.generated.resources.login_email_example
import course.shared.generated.resources.login_goto_home
import course.shared.generated.resources.login_password
import course.shared.generated.resources.login_password_example
import course.shared.generated.resources.login_title
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LoginContainer(
    email : String = "",
    emailError : String = "",
    onEmailChanged : (String) -> Unit = {},
    password : String = "",
    passwordError : String = "",
    passwordVisible : Boolean = false,
    onPasswordVisibilityChanged : (Boolean) -> Unit = {},
    onPasswordChanged : (String) -> Unit = {},
    onLoginClick: () -> Unit = {},
    onHomeClick: () -> Unit = {},
    onCreateAccountClick: () -> Unit = {},
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
        Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height40))
        SimpleCard(
            cardBackgroundColor = AppTheme.colors.primary
        ) {
            Column(modifier = Modifier) {
                TextNormalBold(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    fontSize = Dimens.textSizeBig,
                    color = AppTheme.colors.text.white,
                    text = stringResource(Res.string.login_amount),
                )
                TextNormal(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    fontSize = Dimens.textSizeNormal,
                    color = AppTheme.colors.text.white,
                    text = stringResource(Res.string.login_balance),
                )
                Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height18))
                Image(
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillWidth,
                    painter = painterResource(Res.drawable.ic_mini_chart_2),
                    contentDescription = null,
                )
            }
        }
        Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height50))
        TextFieldCustom(
            value = email,
            errorText = emailError,
            onValueChange = onEmailChanged,
            labelColor = AppTheme.colors.text.black,
            label = stringResource(Res.string.login_email),
            placeholderColor = AppTheme.colors.text.black,
            placeholder = stringResource(Res.string.login_email_example),
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next,
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height12))
        TextFieldPassword(
            password = password,
            errorText = passwordError,
            onPasswordChange = onPasswordChanged,
            passwordVisible = passwordVisible,
            onPasswordVisibleChange = onPasswordVisibilityChanged,
            labelColor = AppTheme.colors.text.black,
            label = stringResource(Res.string.login_password),
            placeholderColor = AppTheme.colors.text.black,
            placeholder = stringResource(Res.string.login_password_example),
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
        Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height28))
        ButtonCustom(
            modifier = Modifier.height(Dimens.height50),
            onClick = onLoginClick,
            backgroundButton = AppTheme.colors.primary,
            textColor = AppTheme.colors.backgrounds.white,
            text = stringResource(Res.string.login_button),
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height24))
        TextButton(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(Res.string.login_create_account),
            fontSize =  Dimens.textSizeSmall,
            color = AppTheme.colors.backgrounds.blue,
            onClick = {
                onCreateAccountClick()
            }
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height24))
        /*ButtonCustom(
            modifier = Modifier.height(Dimens.height50),
            onClick = onHomeClick,
            backgroundButton = AppTheme.colors.primary,
            textColor = AppTheme.colors.backgrounds.white,
            text = stringResource(Res.string.login_goto_home),
        )*/
        Spacer(modifier = Modifier.fillMaxWidth().weight(2f))
    }
}

@Preview(showBackground = true)
@Composable
fun LoginContainerPreview() {
    SafeScreenContainerTest {
        LoginContainer()
    }
}
