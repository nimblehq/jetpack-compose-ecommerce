package co.nimblehq.compose.ecommerce.ui.screen.details

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import co.nimblehq.compose.ecommerce.R
import co.nimblehq.compose.ecommerce.model.mockMoreCubesProducts
import co.nimblehq.compose.ecommerce.model.mockPopularProducts
import co.nimblehq.compose.ecommerce.ui.product.ProductColor
import co.nimblehq.compose.ecommerce.ui.product.ProductSize
import co.nimblehq.compose.ecommerce.ui.product.Products
import co.nimblehq.compose.ecommerce.ui.theme.AppTextStyle
import co.nimblehq.compose.ecommerce.ui.theme.Gray5

@ExperimentalFoundationApi
@Composable
fun ProductDetail(
    productId: Long,
    upPress: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = upPress) {
                        Icon(Icons.Outlined.ArrowBack, null)
                    }
                },
                actions = {
                    IconButton(onClick = {
                        // Handle favorite action
                    }) {
                        Icon(
                            Icons.Rounded.FavoriteBorder,
                            contentDescription = null
                        )
                    }
                    IconButton(onClick = {
                        // Handle share action
                    }) {
                        Icon(
                            Icons.Outlined.Share,
                            contentDescription = null
                        )
                    }
                },
                backgroundColor = Color.White
            )
        }
    ) {
        // FIXME Show the Pink Cube product for detail page as dummy data
        val product = mockPopularProducts.first()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(color = Color.White)
        ) {

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                painter = painterResource(id = R.drawable.ic_shirt_pink_cube),
                contentDescription = null
            )

            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 32.dp),
                text = product?.name.orEmpty(),
                style = AppTextStyle.productDetailName
            )

            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 4.dp),
                text = stringResource(
                    id = R.string.home_product_item_price,
                    formatArgs = arrayOf(product?.price ?: 0)
                ),
                style = AppTextStyle.productDetailPrice
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 20.dp),
                onClick = { /*TODO*/ },
                enabled = true
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 6.dp),
                    text = stringResource(id = R.string.product_add_to_cart),
                    style = AppTextStyle.productDetailAddToCart
                )
            }

            Divider(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp),
                color = Gray5,
                thickness = 1.dp
            )

            Column(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Start),
                    text = stringResource(id = R.string.product_about),
                    style = AppTextStyle.productDetailHeader
                )

                Text(
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(top = 8.dp),
                    text = "The design of Pink Cube was inspired by amazing box. Owning this piece grants the following stats:\n" +
                            "\n" +
                            "Charisma +10\n" +
                            "Luck +10\n" +
                            "Happiness +15",
                    style = AppTextStyle.productDetailAbout
                )
            }

            Divider(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp),
                color = Gray5,
                thickness = 1.dp
            )

            ProductColor()

            Divider(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp),
                color = Gray5,
                thickness = 1.dp
            )

            ProductSize()

            Divider(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp),
                color = Gray5,
                thickness = 1.dp
            )

            Products(
                columnsPerRow = 2,
                sectionTitle = stringResource(id = R.string.product_more_cubes),
                products = mockMoreCubesProducts,
                onProductClick = {}
            )
        }
    }
}
