/*
 * CircularIconButton.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.component.buton

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import course.shared.generated.resources.Res
import course.shared.generated.resources.ic_example
import org.jetbrains.compose.resources.painterResource

@Composable
fun CircularIconButton(
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    size: Dp = Dimens.height24,
    backgroundButton: Color = Color.Transparent,
    borderWidth: Dp = Dimens.border2,
    borderColor: Color = Color.Black,
    iconColor: Color = Color.White,
    icon: Painter,
) {
    Box(
        modifier = modifier
            .clickable(onClick = onClick)
            .size(size)
            .clip(CircleShape)
            .background(color = backgroundButton)
            .border(
                width = borderWidth,
                color = borderColor,
                shape = CircleShape,
            ),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            modifier = Modifier.size(size * 0.5f),
            tint = iconColor,
            painter = icon,
            contentDescription = null,
        )
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
private fun CircularIconButtonPreview() {
    SafeScreenContainerTest {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = Dimens.padding16),
            verticalArrangement = Arrangement.spacedBy(Dimens.padding16),
        ) {
            CircularIconButton(
                backgroundButton = Color.Transparent,
                borderColor = AppTheme.colors.primary,
                iconColor = AppTheme.colors.primary,
                icon = painterResource(Res.drawable.ic_example),
            )
        }
    }
}