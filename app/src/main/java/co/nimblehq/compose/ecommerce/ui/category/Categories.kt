package co.nimblehq.compose.ecommerce.ui.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import co.nimblehq.compose.ecommerce.model.Category
import co.nimblehq.compose.ecommerce.ui.theme.AppTextStyle
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode

@Composable
fun Categories(
    horizontalScroll: Boolean,
    maxWidth: Dp,
    categories: List<Category>
) {
    if (horizontalScroll) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, bottom = 20.dp),
            contentPadding = PaddingValues(horizontal = 16.dp), // Similar clipToPadding
            horizontalArrangement = Arrangement.spacedBy(8.dp) // Space between items
        ) {
            items(categories) { category ->
                CategoryHorizontalItem(category)
            }
        }
    } else {
        val itemPadding = 16.dp
        val itemMaxWidth = (maxWidth - (itemPadding * 2)) / 2
        FlowRow(
            mainAxisSize = SizeMode.Expand,
            mainAxisAlignment = FlowMainAxisAlignment.SpaceEvenly
        ) {
            categories.forEach { category ->
                CategoryVerticalItem(
                    Modifier.requiredWidth(itemMaxWidth),
                    category
                )
            }
        }
    }
}

@Composable
fun CategoryHorizontalItem(
    category: Category
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(onClick = {/* TODO */ })
    ) {
        Image(
            modifier = Modifier.size(80.dp, 62.dp),
            painter = painterResource(id = category.image),
            contentDescription = null
        )

        Text(
            modifier = Modifier.padding(top = 8.dp, bottom = 12.dp),
            text = category.name,
            style = AppTextStyle.category
        )
    }
}

@Composable
fun CategoryVerticalItem(
    modifier: Modifier,
    category: Category
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .clickable(onClick = {/* TODO */ })
    ) {
        Image(
            modifier = modifier,
            painter = painterResource(id = category.image),
            contentDescription = null
        )

        Text(
            modifier = modifier,
            text = category.name,
            style = AppTextStyle.category
        )
    }
}
