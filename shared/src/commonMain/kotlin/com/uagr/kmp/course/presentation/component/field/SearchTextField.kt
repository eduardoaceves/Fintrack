/*
 * SearchTextField.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.component.field

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.text.TextMedium
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import course.shared.generated.resources.Res
import course.shared.generated.resources.example
import course.shared.generated.resources.ic_search
import course.shared.generated.resources.ic_visibility_off
import course.shared.generated.resources.ic_visibility_on
import course.shared.generated.resources.transactions_filter_searc
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun SearchTextField(
    modifier: Modifier = Modifier,
    text : String,
    onTextChange: (String) -> Unit,
    fontSize: TextUnit = Dimens.textSizeNormal,
    labelColor: Color,
    label: String,
    labelTextAlign: TextAlign = TextAlign.Start,
    placeholderColor: Color,
    placeholder: String,
    placeholderTextAlign: TextAlign = TextAlign.Start,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Done,
    capitalization: KeyboardCapitalization = KeyboardCapitalization.Words,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = text,
        onValueChange = onTextChange,
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
        /*label = {
            TextMediumBold(
                fontSize = Dimens.textSizeNormal,
                color = labelColor,
                text = label,
                textAlign = labelTextAlign,
            )
        },*/
        placeholder = {
            TextMedium(
                fontSize = Dimens.textSizeSmall,
                color = placeholderColor,
                text = placeholder,
                textAlign = placeholderTextAlign,
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(Res.drawable.ic_search),
                modifier = Modifier.size(18.dp),
                contentDescription = null,
            )
        },
        singleLine = true,
        shape = RoundedCornerShape(Dimens.corner14),
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
    showSystemUi = true
)
@Composable
private fun SearchTextFieldPreview() {
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
                SearchTextField(
                    text = "",
                    onTextChange = {},
                    labelColor = Color.Black,
                    label = stringResource(Res.string.transactions_filter_searc),
                    placeholderColor = Color.Black,
                    placeholder = stringResource(Res.string.transactions_filter_searc),
                    keyboardType = KeyboardType.Password,
                    capitalization = KeyboardCapitalization.None,
                )
            }
        }
    }
}
