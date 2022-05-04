package co.nimblehq.compose.ecommerce.ui.screen.search

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.nimblehq.compose.ecommerce.R
import co.nimblehq.compose.ecommerce.model.mockSearchResultProducts
import co.nimblehq.compose.ecommerce.ui.product.ProductItem
import co.nimblehq.compose.ecommerce.ui.theme.AppTextStyle
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode

@ExperimentalFoundationApi
@Composable
fun SearchResultScreen(
    searchKey: String,
    columnsPerRow: Int = 2,
    onProductClick: (Long) -> Unit,
    onFilterClick: () -> Unit,
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
                backgroundColor = Color.White,
                elevation = 0.dp
            )
        }
    ) {
        val itemPadding = 16.dp
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(color = Color.White)
                .padding(horizontal = itemPadding)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.CenterStart),
                    text = searchKey,
                    style = AppTextStyle.searchResultHeader
                )

                Text(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .clickable {
                            onFilterClick()
                        },
                    text = stringResource(R.string.filters_applied, 1),
                    style = AppTextStyle.searchResultFilter
                )
            }

            val products = mockSearchResultProducts

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
}

@ExperimentalFoundationApi
@Composable
@Preview
fun SearchResultScreenPreview() {
    SearchResultScreen(
        searchKey = "Cube",
        columnsPerRow = 2,
        onProductClick = {},
        onFilterClick = {},
        upPress = {}
    )
}
