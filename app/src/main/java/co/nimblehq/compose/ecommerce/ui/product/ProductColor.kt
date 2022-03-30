package co.nimblehq.compose.ecommerce.ui.product

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.nimblehq.compose.ecommerce.R
import co.nimblehq.compose.ecommerce.ui.theme.*
import co.nimblehq.compose.ecommerce.ui.theme.AppTextStyle.productSize

@ExperimentalFoundationApi
@Preview
@Composable
fun ProductColor() {

    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Text(
            modifier = Modifier.align(Alignment.Start),
            text = stringResource(id = R.string.product_color),
            style = AppTextStyle.productDetailHeader
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
        ) {
            val modifier = Modifier
                .weight(1f)
                .border(
                    border = BorderStroke(1.dp, color = Purple700),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(top = 14.dp, bottom = 14.dp)

            Column(
                modifier = modifier,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(Pink)
                )

                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    text = stringResource(id = R.string.product_color_pink),
                    style = productSize
                )
            }


            Spacer(modifier = Modifier.width(8.dp))

            Column(
                modifier = modifier,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(Indigo)
                )

                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    text = stringResource(id = R.string.product_color_indigo),
                    style = productSize
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
        ) {
            val modifier = Modifier
                .weight(1f)
                .border(
                    border = BorderStroke(1.dp, color = Purple700),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(top = 14.dp, bottom = 14.dp)

            Column(
                modifier = modifier,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(Honey)
                )

                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    text = stringResource(id = R.string.product_color_honey),
                    style = productSize
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column(
                modifier = modifier,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(Gray4)
                )

                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    text = stringResource(id = R.string.product_color_gray),
                    style = productSize
                )
            }
        }
    }
}