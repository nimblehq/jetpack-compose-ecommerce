package co.nimblehq.compose.ecommerce.ui.product

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import co.nimblehq.compose.ecommerce.R
import co.nimblehq.compose.ecommerce.model.Product
import co.nimblehq.compose.ecommerce.model.mockPopularProducts
import co.nimblehq.compose.ecommerce.ui.theme.AppTextStyle

@ExperimentalFoundationApi
@Composable
fun Products(
    products: List<Product>
) {

    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier.align(Alignment.CenterStart),
                text = stringResource(R.string.home_popular_products_title),
                style = AppTextStyle.productSectionHeader
            )

            Text(
                modifier = Modifier.align(Alignment.CenterEnd),
                text = stringResource(R.string.home_action_shop_all),
                style = AppTextStyle.shopAll
            )
        }

        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(top = 8.dp)
        ) {
            items(products) { item ->
                ProductItem(item)
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun ProductsPreview() {
    Products(products = mockPopularProducts)
}

@Composable
fun ProductItem(
    product: Product
) {
    ConstraintLayout {
        val (ivProduct, ivFavorite, tvProductName, tvProductPrice) = createRefs()

        Image(
            modifier = Modifier
                .constrainAs(ivFavorite) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                }
                .padding(top = 8.dp, end = 4.dp),
            painter = painterResource(id = R.drawable.ic_favorite), contentDescription = null
        )

        Image(
            modifier = Modifier
                .constrainAs(ivProduct) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                },
            painter = painterResource(id = product.image), contentDescription = null
        )

        Text(
            modifier = Modifier
                .constrainAs(tvProductName) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(ivProduct.bottom)
                }
                .padding(top = 8.dp),
            style = AppTextStyle.productItemName,
            text = product.name
        )

        Text(
            modifier = Modifier.constrainAs(tvProductPrice) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(tvProductName.bottom)
            },
            style = AppTextStyle.productItemPrice,
            text = stringResource(
                id = R.string.home_product_item_price,
                formatArgs = arrayOf(product.price)
            )
        )
    }
}

@Composable
@Preview
fun ProductItemPreview() {
    ProductItem(
        Product(
            id = 1,
            name = "Pink Cube",
            price = 8000,
            image = R.drawable.ic_shirt
        )
    )
}
