/*
 * TextField.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.component.field

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.text.TextMedium
import com.uagr.kmp.course.presentation.component.text.TextMediumBold
import com.uagr.kmp.course.presentation.component.text.TextSmallExtra
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import course.shared.generated.resources.Res
import course.shared.generated.resources.example
import course.shared.generated.resources.ic_example
import course.shared.generated.resources.ic_visibility_off
import course.shared.generated.resources.ic_visibility_on
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun TextFieldCustom(
    modifier: Modifier = Modifier,
    value: String,
    fontSize: TextUnit = Dimens.textSizeNormal,
    onValueChange: (String) -> Unit,
    labelColor: Color,
    label: String,
    labelTextAlign: TextAlign = TextAlign.Start,
    placeholderColor: Color,
    placeholder: String,
    placeholderTextAlign: TextAlign = TextAlign.Start,
    errorText : String? = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Done,
    capitalization: KeyboardCapitalization = KeyboardCapitalization.None,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        textStyle = TextStyle(
            fontSize = fontSize,
            fontWeight = FontWeight.Normal,
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction,
            capitalization = capitalization
        ),
        keyboardActions = keyboardActions,
        label = {
            TextMediumBold(
                fontSize = Dimens.textSizeNormal,
                color = labelColor,
                text = label,
                textAlign = labelTextAlign,
            )
        },
        placeholder = {
            TextMedium(
                fontSize = Dimens.textSizeNormal,
                color = placeholderColor,
                text = placeholder,
                textAlign = placeholderTextAlign,
            )
        },
        singleLine = true,
        shape = RoundedCornerShape(Dimens.corner8),
        supportingText = {
            errorText?.let {
                TextSmallExtra(
                    color = AppTheme.colors.error,
                    text = errorText,
                    textAlign = TextAlign.Start
                )
            }
        },
        colors = TextFieldDefaults.colors(
            focusedTextColor = MaterialTheme.colorScheme.onBackground,
            unfocusedTextColor = MaterialTheme.colorScheme.onBackground,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            focusedLabelColor = AppTheme.colors.text.gray,
            unfocusedLabelColor = AppTheme.colors.text.gray
        ),
    )
}

@Composable
fun TextFieldPassword(
    modifier: Modifier = Modifier,
    password : String,
    onPasswordChange: (String) -> Unit,
    passwordVisible: Boolean,
    onPasswordVisibleChange: (Boolean) -> Unit,
    fontSize: TextUnit = Dimens.textSizeNormal,
    labelColor: Color,
    label: String,
    labelTextAlign: TextAlign = TextAlign.Start,
    placeholderColor: Color,
    placeholder: String,
    placeholderTextAlign: TextAlign = TextAlign.Start,
    trailingIconActive: DrawableResource,
    trailingIconInActive: DrawableResource,
    errorText : String? = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Done,
    capitalization: KeyboardCapitalization = KeyboardCapitalization.Words,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = password,
        onValueChange = onPasswordChange,
        textStyle = TextStyle(
            fontSize = fontSize,
            fontWeight = FontWeight.Normal,
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction,
            capitalization = capitalization
        ),
        keyboardActions = keyboardActions,
        label = {
            TextMediumBold(
                fontSize = Dimens.textSizeNormal,
                color = labelColor,
                text = label,
                textAlign = labelTextAlign,
            )
        },
        placeholder = {
            TextMedium(
                fontSize = Dimens.textSizeNormal,
                color = placeholderColor,
                text = placeholder,
                textAlign = placeholderTextAlign,
            )
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { onPasswordVisibleChange(!passwordVisible) }) {
                Icon(
                    painter = painterResource(if (passwordVisible) trailingIconActive else trailingIconInActive),
                    contentDescription = null,
                )
            }
        },
        supportingText = {
            errorText?.let {
                TextSmallExtra(
                    color = AppTheme.colors.error,
                    text = errorText,
                    textAlign = TextAlign.Start
                )
            }
        },
        singleLine = true,
        shape = RoundedCornerShape(Dimens.corner8),
        colors = TextFieldDefaults.colors(
            focusedTextColor = MaterialTheme.colorScheme.onBackground,
            unfocusedTextColor = MaterialTheme.colorScheme.onBackground,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            focusedLabelColor = AppTheme.colors.text.gray,
            unfocusedLabelColor = AppTheme.colors.text.gray
        ),
    )
}

@Preview(
    showBackground = true,
)
@Composable
private fun TextFieldPreview() {
    SafeScreenContainerTest {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = Dimens.padding16),
            verticalArrangement = Arrangement.spacedBy(Dimens.padding16),
        ) {
            Column(
                modifier = Modifier.padding(all = Dimens.padding16),
                verticalArrangement = Arrangement.spacedBy(Dimens.padding16),
            ) {
                TextFieldCustom(
                    value = "",
                    onValueChange = {},
                    labelColor = Color.Black,
                    label = stringResource(Res.string.example),
                    placeholderColor = Color.Black,
                    placeholder = stringResource(Res.string.example),
                )
                TextFieldPassword(
                    password = "",
                    onPasswordChange = {},
                    passwordVisible = false,
                    onPasswordVisibleChange = {},
                    labelColor = Color.Black,
                    label = stringResource(Res.string.example),
                    placeholderColor = Color.Black,
                    placeholder = stringResource(Res.string.example),
                    trailingIconActive = Res.drawable.ic_visibility_on,
                    trailingIconInActive = Res.drawable.ic_visibility_off,
                    keyboardType = KeyboardType.Password,
                    capitalization = KeyboardCapitalization.None,
                )
            }
        }
    }
}
