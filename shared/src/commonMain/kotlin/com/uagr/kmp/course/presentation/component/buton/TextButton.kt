/*
 * TextButton.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.component.buton

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import course.shared.generated.resources.Res
import course.shared.generated.resources.login_create_account
import org.jetbrains.compose.resources.stringResource

@Composable
fun TextButton(
    title : String,
    fontSize: TextUnit = Dimens.textSizeSmall,
    color: Color = AppTheme.colors.backgrounds.blue,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    TextButton(
        modifier = modifier,
        onClick = {
            onClick()
        }
    ) {
        Text(
            style = AppTheme.typography.bodyMedium.copy(
                fontSize = fontSize,
                fontWeight = FontWeight.Bold,
            ),
            color = color,
            text = title
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
private fun TextButtonPreview() {
    SafeScreenContainerTest {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = Dimens.padding16),
            verticalArrangement = Arrangement.spacedBy(Dimens.padding16),
        ) {
            TextButton(
                modifier = Modifier.fillMaxWidth(),
                title = stringResource(Res.string.login_create_account),
                fontSize =  Dimens.textSizeSmall,
                color = AppTheme.colors.backgrounds.blue,
                onClick = {
                
                }
            )
        }
    }
}

