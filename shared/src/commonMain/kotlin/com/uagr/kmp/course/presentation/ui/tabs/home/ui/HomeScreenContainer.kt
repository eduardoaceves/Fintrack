package com.uagr.kmp.course.presentation.ui.tabs.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.style.TextAlign
import com.uagr.kmp.course.presentation.component.card.BalanceCard
import com.uagr.kmp.course.presentation.component.card.SimpleCard
import com.uagr.kmp.course.presentation.component.text.TextMedium
import com.uagr.kmp.course.presentation.component.text.TextNormal
import com.uagr.kmp.course.presentation.component.text.TextNormalBold
import com.uagr.kmp.course.presentation.component.text.TextSmall
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import course.shared.generated.resources.Res
import course.shared.generated.resources.home_amount
import course.shared.generated.resources.home_bills
import course.shared.generated.resources.home_down_percentage
import course.shared.generated.resources.home_hello
import course.shared.generated.resources.home_income
import course.shared.generated.resources.home_month
import course.shared.generated.resources.home_negative_amount
import course.shared.generated.resources.home_positive_amount
import course.shared.generated.resources.home_saving
import course.shared.generated.resources.home_title
import course.shared.generated.resources.home_total_balance
import course.shared.generated.resources.home_up_percentage
import org.jetbrains.compose.resources.stringResource

@Composable
fun HomeScreenContainer(){
    
    val scrollState = rememberScrollState()
    val focusManager = LocalFocusManager.current
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = Dimens.padding16)
            .verticalScroll(state = scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.fillMaxWidth().weight(1f))
        TextNormal(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            fontSize = Dimens.textSizeNormal,
            color = AppTheme.colors.text.gray,
            text = stringResource(Res.string.home_hello)
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height8))
        TextNormalBold(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            fontSize = Dimens.textSize28sp,
            color = AppTheme.colors.text.black,
            text = stringResource(Res.string.home_title),
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height20))
        SimpleCard(
            cardBackgroundColor = AppTheme.colors.primary
        ) {
            Column(modifier = Modifier) {
                TextNormal(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    fontSize = Dimens.textSizeNormal,
                    color = AppTheme.colors.text.white,
                    text = stringResource(Res.string.home_total_balance),
                )
                Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height13))
                TextNormalBold(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    fontSize = Dimens.textSizeBig,
                    color = AppTheme.colors.text.white,
                    text = stringResource(Res.string.home_amount),
                )
                Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height21))
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        TextSmall(
                            textAlign = TextAlign.Start,
                            fontSize = Dimens.textSize12sp,
                            color = AppTheme.colors.text.white,
                            text = stringResource(Res.string.home_income),
                        )
                        Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height7))
                        TextMedium(
                            textAlign = TextAlign.Start,
                            fontSize = Dimens.textSize14sp,
                            color = AppTheme.colors.text.white,
                            text = stringResource(Res.string.home_positive_amount)
                        )
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        TextSmall(
                            textAlign = TextAlign.Start,
                            fontSize = Dimens.textSize12sp,
                            color = AppTheme.colors.text.white,
                            text = stringResource(Res.string.home_bills),
                        )
                        Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height7))
                        TextMedium(
                            textAlign = TextAlign.Start,
                            fontSize = Dimens.textSize14sp,
                            color = AppTheme.colors.text.white,
                            text = stringResource(Res.string.home_negative_amount)
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height28))
        TextNormalBold(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            fontSize = Dimens.textSize18sp,
            color = AppTheme.colors.text.black,
            text = stringResource(Res.string.home_month)
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height14))
        Row(modifier = Modifier.fillMaxWidth()) {
            BalanceCard(
                modifier = Modifier.weight(1f),
                title = stringResource(Res.string.home_bills),
                amount = stringResource(Res.string.home_amount),
                percentage = stringResource(Res.string.home_down_percentage),
            )
            Spacer(modifier = Modifier.fillMaxWidth().weight(.2f))
            BalanceCard(
                modifier = Modifier.weight(1f),
                title = stringResource(Res.string.home_saving),
                amount = stringResource(Res.string.home_amount),
                percentage = stringResource(Res.string.home_up_percentage),
            )
        }
        Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height14))
        
        
        Spacer(modifier = Modifier.fillMaxWidth().weight(2f))
    }
}