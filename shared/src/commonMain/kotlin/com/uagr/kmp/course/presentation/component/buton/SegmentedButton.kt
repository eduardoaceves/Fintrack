package com.uagr.kmp.course.presentation.component.buton

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.theme.Dimens


@Composable
fun SingleChoiceSegmentedButton(modifier: Modifier = Modifier) {
    var selectedIndex by remember { mutableIntStateOf(0) }
    val options = listOf("Todos", "Ingreso", "Gastos")
    SingleChoiceSegmentedButtonRow {
        options.forEachIndexed { index, label ->
            SegmentedButton(
                shape = SegmentedButtonDefaults.itemShape(
                    baseShape = RoundedCornerShape(Dimens.corner22),
                    index = index,
                    count = options.size
                ),
                onClick = { selectedIndex = index },
                selected = index == selectedIndex,
                label = { Text(label) }
            )
        }
    }
}


@Composable
fun GenderSelector() {
    val options = listOf("Male", "Female", "Other")
    var selectedIndex by rememberSaveable { mutableStateOf(0) }
    
    SingleChoiceSegmentedButtonRow {
        options.forEachIndexed { index, label ->
            SegmentedButton(
                selected = selectedIndex == index,
                onClick = { selectedIndex = index },
                shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                modifier = Modifier.padding(vertical = 4.dp),
            ) {
                Text(label)
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun SingleChoiceSegmentedButtonPreview() {
    SafeScreenContainerTest {
        Column {
            SingleChoiceSegmentedButton()
            Spacer(modifier = Modifier.fillMaxWidth().height(Dimens.height22))
            GenderSelector()
        }
    }
}