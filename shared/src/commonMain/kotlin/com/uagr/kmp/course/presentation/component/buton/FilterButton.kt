/*
 * FilterButton.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.component.buton

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.text.TextNormalBold
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import com.uagr.kmp.course.utils.constant.Constants
import course.shared.generated.resources.Res
import course.shared.generated.resources.login_create_account
import course.shared.generated.resources.transactions_filter_all
import course.shared.generated.resources.transactions_filter_expends
import course.shared.generated.resources.transactions_filter_incomes
import org.jetbrains.compose.resources.stringResource

@Composable
fun FilterButton(
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    backgroundButton: Color = Color.Black,
    height: Dp = Dimens.height35,
    width: Dp = Dimens.height35,
    enabled: Boolean = true,
    shape: Shape = RoundedCornerShape(size = Dimens.corner20),
    textColor: Color = Color.White,
    text: String = "",
    fontSize: TextUnit = Dimens.textSize11sp,
    textAlign : TextAlign = TextAlign.Start
) {
    Button(
        onClick = onClick,
        modifier = modifier.width(width),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundButton),
        enabled = enabled,
        shape = shape,
    ) {
        TextNormalBold(
            textAlign = textAlign,
            modifier = Modifier,
            color = textColor,
            fontSize = fontSize,
            text = text,
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
private fun FilterButtonPreview() {
    SafeScreenContainerTest {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = Dimens.padding16),
            verticalArrangement = Arrangement.spacedBy(Dimens.padding16),
        ) {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start)
            {
                FilterButton(
                    backgroundButton = AppTheme.colors.backgrounds.blue,
                    textColor = AppTheme.colors.backgrounds.white,
                    width = Dimens.width100,
                    text = stringResource(Res.string.transactions_filter_all),
                    fontSize = Dimens.textSize11sp,
                    onClick = { }
                )
                Spacer(Modifier.width(Dimens.padding10))
                FilterButton(
                    backgroundButton = AppTheme.colors.backgrounds.greenActive,
                    textColor = AppTheme.colors.backgrounds.white,
                    width = Dimens.width100,
                    text = stringResource(Res.string.transactions_filter_incomes),
                    fontSize = Dimens.textSize11sp,
                    onClick = { }
                )
                Spacer(Modifier.width(Dimens.padding10))
                FilterButton(
                    backgroundButton = AppTheme.colors.backgrounds.redActive,
                    textColor = AppTheme.colors.backgrounds.white,
                    width = Dimens.width100,
                    text = stringResource(Res.string.transactions_filter_expends),
                    fontSize = Dimens.textSize11sp,
                    onClick = { }
                )
            }
        }
    }
}

