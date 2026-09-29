package com.uagr.kmp.course.presentation.component.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.text.TextMedium
import com.uagr.kmp.course.presentation.component.text.TextNormalBold
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import com.uagr.kmp.course.presentation.ui.login.ui.LoginContainer
import course.shared.generated.resources.Res
import course.shared.generated.resources.home_amount
import course.shared.generated.resources.home_bills
import course.shared.generated.resources.home_saving
import course.shared.generated.resources.home_up_percentage
import org.jetbrains.compose.resources.stringResource

@Composable
fun BalanceCard(
    title : String? = stringResource(Res.string.home_bills),
    amount : String? = stringResource(Res.string.home_amount),
    percentage : String? = stringResource(Res.string.home_up_percentage),
    modifier: Modifier = Modifier
){
    SimpleCard(
        modifierCard = modifier,
        cardBackgroundColor = AppTheme.colors.backgrounds.white
    ) {
        Column(modifier = Modifier) {
            TextMedium(
                textAlign = TextAlign.Start,
                fontSize = Dimens.textSize14sp,
                color = AppTheme.colors.text.gray,
                text = title.orEmpty()
            )
            Spacer(modifier = Modifier.height(Dimens.height6))
            TextNormalBold(
                textAlign = TextAlign.Start,
                fontSize = Dimens.textSizeNormal,
                color = AppTheme.colors.text.black,
                text = amount.orEmpty()
            )
            Spacer(modifier = Modifier.height(Dimens.height6))
            /*TextNormalBold(
                textAlign = TextAlign.Start,
                fontSize = Dimens.textSize12sp,
                color = AppTheme.colors.text.green,
                text = percentage.orEmpty()
            )*/
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BalanceCardPreview() {
    SafeScreenContainerTest {
        BalanceCard(
            modifier = Modifier,
            title = stringResource(Res.string.home_saving),
            amount = stringResource(Res.string.home_amount),
            percentage = stringResource(Res.string.home_up_percentage),
        )
    }
}
