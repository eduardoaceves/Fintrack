/*
 * CustomButton.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.component.buton

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.text.TextNormalBold
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import course.shared.generated.resources.Res
import course.shared.generated.resources.example
import org.jetbrains.compose.resources.stringResource


@Composable
fun CustomButton(
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    backgroundButton: Color = Color.Black,
    height: Dp = Dimens.height40,
    enabled: Boolean = true,
    shape: Shape = RoundedCornerShape(size = Dimens.corner20),
    textColor: Color = Color.White,
    text: String = "",
    textAlign : TextAlign = TextAlign.Start
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(height = height),
        colors = ButtonDefaults.buttonColors(contentColor = backgroundButton),
        enabled = enabled,
        shape = shape,
    ) {
        TextNormalBold(
            textAlign = textAlign,
            modifier = Modifier.fillMaxWidth(),
            color = textColor,
            text = text,
        )
    }
}




@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
private fun CustomButtonPreview() {
    SafeScreenContainerTest {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = Dimens.padding16),
            verticalArrangement = Arrangement.spacedBy(Dimens.padding16),
        ) {
            CustomButton(
                backgroundButton = AppTheme.colors.primary,
                textColor = AppTheme.colors.backgrounds.white,
                text = stringResource(Res.string.example),
            )
        }
    }
}
