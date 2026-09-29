/*
 * TransactionsScreenContainer.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.tabs.transactions.iu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.text.TextNormal
import com.uagr.kmp.course.presentation.component.text.TextNormalBold
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import course.shared.generated.resources.Res
import course.shared.generated.resources.transactions_date
import course.shared.generated.resources.transactions_title
import org.jetbrains.compose.resources.stringResource

@Composable
fun TransactionsScreenContainer(){
    
    val scrollState = rememberScrollState()
    val focusManager = LocalFocusManager.current
    
    Column(
        modifier = Modifier.padding(all = Dimens.padding16)
            .background(color = AppTheme.colors.backgrounds.canvas)
            .fillMaxSize()
            .verticalScroll(state = scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.fillMaxWidth().weight(1f))
        TextNormalBold(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            fontSize = Dimens.textSize28sp,
            color = AppTheme.colors.text.black,
            text = stringResource(Res.string.transactions_date),
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height8))
        TextNormal(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            fontSize = Dimens.textSizeNormal,
            color = AppTheme.colors.text.gray,
            text = stringResource(Res.string.transactions_title)
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height20))
        Row(modifier = Modifier) {
        
        }
        Spacer(modifier = Modifier.fillMaxWidth().weight(2f))
    }
}

@Preview(showBackground = true)
@Composable
fun TransactionsScreenContainerPreview() {
    SafeScreenContainerTest {
        TransactionsScreenContainer()
    }
}