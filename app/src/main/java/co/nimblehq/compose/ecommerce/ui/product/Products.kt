package co.nimblehq.compose.ecommerce.ui.product

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import co.nimblehq.compose.ecommerce.R
import co.nimblehq.compose.ecommerce.model.Product
import co.nimblehq.compose.ecommerce.model.mockPopularProducts
import co.nimblehq.compose.ecommerce.ui.theme.AppTextStyle
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode

@ExperimentalFoundationApi
@Composable
fun Products(
    columnsPerRow: Int,
    sectionTitle: String,
    products: List<Product>,
    onProductClick: (Long) -> Unit
) {
    val itemPadding = 16.dp
    Column(
        modifier = Modifier.padding(horizontal = itemPadding)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier.align(Alignment.CenterStart),
                text = sectionTitle,
                style = AppTextStyle.productSectionHeader
            )

            Text(
                modifier = Modifier.align(Alignment.CenterEnd),
                text = stringResource(R.string.home_action_shop_all),
                style = AppTextStyle.shopAll
            )
        }

        // Workaround solution: https://medium.com/tech-takeaways/scrollable-grid-view-with-jetpack-compose-aed9f2b9c382
        val itemMaxWidth =
            (LocalConfiguration.current.screenWidthDp.dp - (itemPadding * 2)) / columnsPerRow
        FlowRow(
            mainAxisSize = SizeMode.Expand,
            mainAxisAlignment = FlowMainAxisAlignment.SpaceEvenly
        ) {
            products.forEachIndexed { index, product ->
                val modifier = if (index % 2 == 0) {
                    Modifier
                        .requiredWidth(itemMaxWidth)
                        .padding(end = 8.dp)
                } else {
                    Modifier
                        .requiredWidth(itemMaxWidth)
                        .padding(start = 8.dp)
                }
                ProductItem(
                    modifier = modifier,
                    product = product,
                    onProductClick = onProductClick
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun ProductsPreview() {
    Products(
        columnsPerRow = 2,
        sectionTitle = stringResource(R.string.home_popular_products_title),
        products = mockPopularProducts,
        onProductClick = {}
    )
}

@Composable
fun ProductItem(
    modifier: Modifier,
    product: Product,
    onProductClick: (Long) -> Unit
) {
    ConstraintLayout(modifier = modifier
        .padding(bottom = 8.dp)
        .clickable {
            onProductClick(product.id)
        }) {
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
        Modifier.fillMaxWidth(),
        Product(
            id = 1,
            name = "Pink Cube",
            price = 8000,
            image = R.drawable.ic_shirt_honey_cube
        )
    ) {}
}
