/*
 * PackagesContainer.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.packages.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.uagr.kmp.course.domain.model.packages.PackagesDataModel
import com.uagr.kmp.course.presentation.component.card.PackagesCard
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.mock.packagesDataListMock
import com.uagr.kmp.course.presentation.component.text.TextBigBold
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import course.shared.generated.resources.Res
import course.shared.generated.resources.empty_packages
import org.jetbrains.compose.resources.stringResource

@Composable
fun PackagesContainer(
    packages: List<PackagesDataModel> = emptyList(),
    activePackagesClick: () -> Unit = {},
) {
    if (packages.isNotEmpty()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = Dimens.padding16),
            verticalArrangement = Arrangement.spacedBy(
                space = Dimens.padding16,
                alignment = Alignment.CenterVertically,
            ),
        ) {
            items(count = packages.size) { index ->
                packages[index].let { packageItem ->
                    PackagesCard(
                        onClick = activePackagesClick,
                        nameText = packageItem.name,
                        typeText = packageItem.description,
                        quantityText = packageItem.price,
                        unit = packageItem.currency,
                        renewalText = packageItem.created_by,
                        buttonText = packageItem.created_at,
                    )
                }
            }
        }
    } else {
        TextBigBold(
            modifier = Modifier.fillMaxWidth(),
            color = AppTheme.colors.backgrounds.black,
            text = stringResource(Res.string.empty_packages),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PackagesContainerPreview() {
    SafeScreenContainerTest {
        PackagesContainer(packages = packagesDataListMock)
    }
}
