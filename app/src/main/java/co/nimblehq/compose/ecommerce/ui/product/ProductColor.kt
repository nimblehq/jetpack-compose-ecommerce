package co.nimblehq.compose.ecommerce.ui.product

import androidx.annotation.StringRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.nimblehq.compose.ecommerce.R
import co.nimblehq.compose.ecommerce.ui.theme.*
import co.nimblehq.compose.ecommerce.ui.theme.AppTextStyle.productSize
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode

@ExperimentalFoundationApi
@Preview
@Composable
fun ProductColor() {

    val selectedColor = remember { mutableStateOf(0) }
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 8.dp),
            text = stringResource(id = R.string.product_color),
            style = AppTextStyle.productDetailHeader
        )

        val listOfColor = listOf(
            Pink to R.string.product_color_pink,
            Indigo to R.string.product_color_indigo,
            Honey to R.string.product_color_honey,
            Gray4 to R.string.product_color_gray,
        )

        val spacer = 8.dp
        val itemMaxWidth =
            (LocalConfiguration.current.screenWidthDp.dp - (16.dp * 2) - spacer) / 2
        FlowRow(
            mainAxisSize = SizeMode.Expand,
            mainAxisAlignment = FlowMainAxisAlignment.SpaceEvenly
        ) {
            listOfColor.forEachIndexed { index, (color, stringResId) ->
                val borderColor = if (selectedColor.value == index) {
                    Purple700
                } else {
                    Gray7
                }

                val modifier = Modifier
                    .requiredWidth(itemMaxWidth)
                    .padding(bottom = 8.dp)
                    .border(
                        border = BorderStroke(1.dp, color = borderColor),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(top = 14.dp, bottom = 14.dp)

                ColorPicker(
                    modifier = modifier,
                    color = color,
                    stringId = stringResId,
                    onClick = { selectedColor.value = index }
                )

                if (index % 2 == 0) {
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    }
}

@Composable
fun ColorPicker(
    modifier: Modifier,
    color: Color,
    @StringRes stringId: Int,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier.clickable { onClick() },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(CircleShape)
                .background(color)
        )

        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = stringResource(id = stringId),
            style = productSize
        )
    }
}
