/*
 * PackagesCard.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.component.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.uagr.kmp.course.presentation.component.buton.ButtonCustom
import com.uagr.kmp.course.presentation.component.buton.CircularIconButtonCustom
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.text.TextBigBold
import com.uagr.kmp.course.presentation.component.text.TextNormalBold
import com.uagr.kmp.course.presentation.component.text.TextSmall
import com.uagr.kmp.course.presentation.component.text.TextSmallExtra
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import course.shared.generated.resources.Res
import course.shared.generated.resources.ic_info
import org.jetbrains.compose.resources.painterResource

@Composable
fun PackagesCard(
    onClick: () -> Unit = {},
    modifierCard: Modifier = Modifier,
    modifierColum: Modifier = Modifier,
    nameText: String = "",
    typeText: String = "",
    quantityText: String = "",
    unit: String = "",
    renewalText : String = "",
    buttonText: String = "",
) {
    SimpleCard(
        modifierCard = modifierCard,
        modifierColumn = modifierColum,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(Dimens.height4),
            ) {
                TextNormalBold(
                    modifier = Modifier.fillMaxWidth(),
                    color = AppTheme.colors.backgrounds.black,
                    text = nameText,
                    textAlign = TextAlign.Left,
                )
                TextSmall(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Gray,
                    text = typeText,
                    textAlign = TextAlign.Left,
                )
            }
            CircularIconButtonCustom(
                backgroundButton = Color.Transparent,
                borderColor = AppTheme.colors.primary,
                iconColor = AppTheme.colors.primary,
                icon = painterResource(Res.drawable.ic_info),
            )
        }

        Spacer(modifier = Modifier.height(Dimens.height20))

        TextBigBold(
            modifier = Modifier.fillMaxWidth(),
            fontSize = Dimens.textSizeBigExtra,
            color = AppTheme.colors.backgrounds.black,
            text = quantityText,
            textAlign = TextAlign.Center,
        )

        TextSmall(
            modifier = Modifier.fillMaxWidth(),
            color = AppTheme.colors.backgrounds.black,
            text = unit,
        )

        Spacer(modifier = Modifier.height(Dimens.height16))

        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = Dimens.height2,
            color = AppTheme.colors.divider,
        )

        Spacer(modifier = Modifier.height(Dimens.height12))

        TextSmallExtra(
            modifier = Modifier.fillMaxWidth(),
            color = Color.Gray,
            text = renewalText,
        )

        Spacer(modifier = Modifier.height(Dimens.height20))

        ButtonCustom(
            onClick = onClick,
            backgroundButton = AppTheme.colors.primary,
            textColor = AppTheme.colors.backgrounds.white,
            text = buttonText,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PackagesCardPreview() {
    SafeScreenContainerTest {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = Dimens.padding16),
            verticalArrangement = Arrangement.spacedBy(space = Dimens.padding16),
        ) {
            PackagesCard(
                nameText = "Internet Full",
                typeText = "Paquete Ilimitado",
                quantityText = "580",
                unit = "MB Usados",
                renewalText = "Renueva en 27 Dias / 5 Abril - 4 Mayo",
                buttonText = "Activa Paquete",
            )
        }
    }
}
