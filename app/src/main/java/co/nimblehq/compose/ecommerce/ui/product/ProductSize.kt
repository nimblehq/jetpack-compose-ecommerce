package co.nimblehq.compose.ecommerce.ui.product

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.nimblehq.compose.ecommerce.R
import co.nimblehq.compose.ecommerce.ui.theme.AppTextStyle
import co.nimblehq.compose.ecommerce.ui.theme.AppTextStyle.productSize
import co.nimblehq.compose.ecommerce.ui.theme.Gray7
import co.nimblehq.compose.ecommerce.ui.theme.Purple700

@ExperimentalFoundationApi
@Preview
@Composable
fun ProductSize() {

    val selectedSize = remember { mutableStateOf(0) }
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Text(
            modifier = Modifier.align(Alignment.Start),
            text = stringResource(id = R.string.product_size),
            style = AppTextStyle.productDetailHeader
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
        ) {
            val listOfSize = listOf(
                R.string.product_size_s,
                R.string.product_size_m,
                R.string.product_size_l,
                R.string.product_size_xl,
            )

            listOfSize.forEachIndexed { index, stringResId ->
                val borderColor = if (selectedSize.value == index) {
                    Purple700
                } else {
                    Gray7
                }
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .border(
                            border = BorderStroke(1.dp, color = borderColor),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(top = 14.dp, bottom = 14.dp)
                        .clickable {
                            selectedSize.value = index
                        },
                    text = stringResource(id = stringResId),
                    style = productSize
                )

                if (index < listOfSize.lastIndex) {
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    }
}