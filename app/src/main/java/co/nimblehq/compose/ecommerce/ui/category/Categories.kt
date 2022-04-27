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
import androidx.compose.ui.unit.dp
import co.nimblehq.compose.ecommerce.model.Category
import co.nimblehq.compose.ecommerce.ui.theme.AppTextStyle

@Composable
fun Categories(
    categories: List<Category>
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, bottom = 20.dp),
        contentPadding = PaddingValues(horizontal = 16.dp), // Similar clipToPadding
        horizontalArrangement = Arrangement.spacedBy(8.dp) // Space between items
    ) {
        items(categories) { category ->
            CategoryItem(category)
        }
    }
}

@Composable
fun CategoryItem(
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
