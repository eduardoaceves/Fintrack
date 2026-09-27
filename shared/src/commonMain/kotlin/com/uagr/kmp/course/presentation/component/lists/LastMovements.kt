package com.uagr.kmp.course.presentation.component.lists

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.text.TextMedium
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import course.shared.generated.resources.Res
import course.shared.generated.resources.home_last_moves
import course.shared.generated.resources.home_see_all
import org.jetbrains.compose.resources.stringResource

@Composable
fun LastMovements(){
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            TextMedium(
                modifier = Modifier.fillMaxWidth().weight(.6f),
                textAlign = TextAlign.Start,
                fontSize = Dimens.textSize18sp,
                color = AppTheme.colors.text.black,
                text = stringResource(Res.string.home_last_moves)
            )
            TextMedium(
                modifier = Modifier.fillMaxWidth().weight(.4f),
                textAlign = TextAlign.End,
                fontSize = Dimens.textSize12sp,
                color = AppTheme.colors.text.blue,
                text = stringResource(Res.string.home_see_all)
            )
        }
        
    }
}


@Preview(showBackground = true)
@Composable
fun LastMovementsPreview() {
    SafeScreenContainerTest {
        LastMovements()
    }
}

