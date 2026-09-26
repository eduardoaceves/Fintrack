/*
 * WelcomeContainer.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.welcome.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.uagr.kmp.course.presentation.component.buton.ButtonCustom
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.text.TextBigBold
import com.uagr.kmp.course.presentation.component.text.TextMedium
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import course.shared.generated.resources.Res
import course.shared.generated.resources.explore_our_multiplatform_platform
import course.shared.generated.resources.go_to_login
import course.shared.generated.resources.hello
import org.jetbrains.compose.resources.stringResource

@Composable
fun WelcomeContainer(
    navigateToPackages: () -> Unit = {},
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Dimens.padding16)
            .verticalScroll(state = scrollState),
        verticalArrangement = Arrangement.spacedBy(
            space = Dimens.padding16,
            alignment = Alignment.CenterVertically,
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextBigBold(
            modifier = Modifier.fillMaxWidth(),
            color = AppTheme.colors.text.black,
            text = stringResource(Res.string.hello),
        )
        TextMedium(
            modifier = Modifier.fillMaxWidth(),
            color = AppTheme.colors.text.black,
            text = stringResource(Res.string.explore_our_multiplatform_platform),
        )
        Spacer(modifier = Modifier.height(Dimens.height16))
        ButtonCustom(
            onClick = navigateToPackages,
            modifier = Modifier.fillMaxWidth(),
            backgroundButton = AppTheme.colors.primary,
            textColor = AppTheme.colors.backgrounds.white,
            text = stringResource(Res.string.go_to_login),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WelcomeContainerPreview() {
    SafeScreenContainerTest {
        WelcomeContainer()
    }
}
