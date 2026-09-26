/*
 * Button.kt
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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.text.TextNormalBold
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import course.shared.generated.resources.Res
import course.shared.generated.resources.example
import course.shared.generated.resources.ic_example
import course.shared.generated.resources.login_create_account
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun TextButton(
    title : String,
    fontSize: TextUnit = Dimens.textSizeSmall,
    color: Color = AppTheme.colors.backgrounds.blue,
    onClick: () -> Unit = {},
   modifier: Modifier = Modifier,
    ){
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

@Composable
fun ButtonCustom(
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

@Composable
fun CircularIconButtonCustom(
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

@Preview(showBackground = true)
@Composable
private fun ButtonCustomPreview() {
    SafeScreenContainerTest {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = Dimens.padding16),
            verticalArrangement = Arrangement.spacedBy(Dimens.padding16),
        ) {
            ButtonCustom(
                backgroundButton = AppTheme.colors.primary,
                textColor = AppTheme.colors.backgrounds.white,
                text = stringResource(Res.string.example),
            )
            CircularIconButtonCustom(
                backgroundButton = Color.Transparent,
                borderColor = AppTheme.colors.primary,
                iconColor = AppTheme.colors.primary,
                icon = painterResource(Res.drawable.ic_example),
            )
            
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
