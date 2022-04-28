package co.nimblehq.compose.ecommerce.ui.screen.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.nimblehq.compose.ecommerce.R
import co.nimblehq.compose.ecommerce.ui.theme.AppTextStyle
import co.nimblehq.compose.ecommerce.ui.theme.AppTextStyle.productEmptyCart

@Composable
fun ProductScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {

        Text(
            modifier = Modifier
                .padding(top = 50.dp, bottom = 21.dp, start = 16.dp, end = 16.dp),
            text = stringResource(R.string.product_my_cart),
            style = AppTextStyle.title
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.CenterHorizontally)
                .wrapContentSize(Alignment.Center)
        ) {
            Image(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                painter = painterResource(id = R.drawable.ic_cart), contentDescription = null
            )

            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp),
                text = stringResource(id = R.string.product_empty_cart),
                style = productEmptyCart
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductScreenPreview() {
    ProductScreen()
}
