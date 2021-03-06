package co.nimblehq.compose.ecommerce.ui.screen.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BadgedBox
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import co.nimblehq.compose.ecommerce.R
import co.nimblehq.compose.ecommerce.model.mockForYouProducts
import co.nimblehq.compose.ecommerce.model.mockNewArrivalsProducts
import co.nimblehq.compose.ecommerce.model.mockPopularProducts
import co.nimblehq.compose.ecommerce.ui.collection.Collection
import co.nimblehq.compose.ecommerce.ui.product.Products
import co.nimblehq.compose.ecommerce.ui.theme.AppTextStyle
import co.nimblehq.compose.ecommerce.ui.theme.Red
import co.nimblehq.compose.ecommerce.utils.WindowSize

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun HomeScreen(onProductClick: (Long) -> Unit, windowSize: WindowSize) {
    val isExpandedScreen = windowSize == WindowSize.Expanded

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = Color.White)
            .wrapContentSize(Alignment.TopCenter)
            .wrapContentSize(Alignment.Center)
    ) {
        // Discovery
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, bottom = 21.dp, start = 16.dp, end = 16.dp)
        ) {
            val (tvDiscover, bbProfile) = createRefs()

            Text(
                modifier = Modifier.constrainAs(tvDiscover) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                },
                text = stringResource(R.string.home_discover),
                style = AppTextStyle.title
            )

            BadgedBox(
                modifier = Modifier.constrainAs(bbProfile) {
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
                badge = {
                    Text(
                        modifier = Modifier
                            .background(color = Red, shape = CircleShape)
                            .defaultMinSize(18.dp),
                        text = "3",
                        textAlign = TextAlign.Center,
                        style = AppTextStyle.badge
                    )
                }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = "Profile",
                    modifier = Modifier.size(38.dp)
                )
            }
        }

        // Suggested for you Collection
        Collection(showOnePanel = !isExpandedScreen)

        // Popular products
        Products(
            columnsPerRow = 2,
            sectionTitle = stringResource(R.string.home_popular_products_title),
            products = mockPopularProducts,
            onProductClick = { productId -> onProductClick(productId) }
        )

        // New arrivals products
        Products(
            columnsPerRow = 2,
            sectionTitle = stringResource(R.string.home_new_arrivals_products_title),
            products = mockNewArrivalsProducts,
            onProductClick = { productId -> onProductClick(productId) }
        )

        // For you products
        Products(
            columnsPerRow = 2,
            sectionTitle = stringResource(R.string.home_for_you_products_title),
            products = mockForYouProducts,
            onProductClick = { productId -> onProductClick(productId) }
        )
    }
}

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
//    HomeScreen(windowSizeClass)
}
