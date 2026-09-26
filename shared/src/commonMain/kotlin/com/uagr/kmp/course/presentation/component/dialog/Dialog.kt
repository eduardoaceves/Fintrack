/*
 * Dialog.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.component.dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.uagr.kmp.course.domain.model.base.ErrorDialogModel
import com.uagr.kmp.course.presentation.component.buton.ButtonCustom
import com.uagr.kmp.course.presentation.component.text.TextNormalBold
import com.uagr.kmp.course.presentation.component.text.TextSmall
import com.uagr.kmp.course.presentation.theme.Dimens
import course.shared.generated.resources.Res
import course.shared.generated.resources.example
import org.jetbrains.compose.resources.stringResource

@Composable
fun DialogCustom(
    modifier: Modifier = Modifier,
    errorDialog: ErrorDialogModel?,
    titleTextColor: Color,
    messageTextColor: Color,
    primaryButtonBackgroundColor: Color,
    primaryButtonTextColor: Color,
    secondaryButtonBackgroundColor: Color = Color.Gray,
    secondaryButtonTextColor: Color = Color.White,
    onPrimaryButtonClick: () -> Unit = {},
    onSecondaryButtonClick: () -> Unit = {},
) {
    errorDialog?.let { errorDialog ->
        AlertDialog(
            modifier = modifier,
            onDismissRequest = {},
            title = {
                TextNormalBold(
                    color = titleTextColor,
                    text = errorDialog.title,
                )
            },
            text = {
                TextSmall(
                    color = messageTextColor,
                    text = errorDialog.message,
                )
            },
            confirmButton = {
                if (errorDialog.primaryButtonText.isNotEmpty()) {
                    ButtonCustom(
                        backgroundButton = primaryButtonBackgroundColor,
                        textColor = primaryButtonTextColor,
                        text = errorDialog.primaryButtonText,
                        onClick = onPrimaryButtonClick,
                    )
                }
            },
            dismissButton = {
                if (errorDialog.secondaryButtonText.isNotEmpty()) {
                    ButtonCustom(
                        backgroundButton = secondaryButtonBackgroundColor,
                        textColor = secondaryButtonTextColor,
                        text = errorDialog.secondaryButtonText,
                        onClick = onSecondaryButtonClick,
                    )
                }
            },
        )
    }
}

@Preview(
    showBackground = true,
)
@Composable
private fun ErrorDialogPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = Dimens.padding16),
        verticalArrangement = Arrangement.spacedBy(Dimens.padding16),
    ) {
        DialogCustom(
            errorDialog = ErrorDialogModel(
                title = stringResource(Res.string.example),
                message = stringResource(Res.string.example),
                primaryButtonText = stringResource(Res.string.example),
            ),
            titleTextColor = Color.Black,
            messageTextColor = Color.Black,
            primaryButtonBackgroundColor = Color.Black,
            primaryButtonTextColor = Color.White,
            secondaryButtonBackgroundColor = Color.Black,
            secondaryButtonTextColor = Color.White,
        )
    }
}
