package co.nimblehq.compose.ecommerce.ui.screen.search

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.nimblehq.compose.ecommerce.R
import co.nimblehq.compose.ecommerce.model.mockShapes
import co.nimblehq.compose.ecommerce.ui.shape.Shapes
import co.nimblehq.compose.ecommerce.ui.theme.AppTextStyle
import co.nimblehq.compose.ecommerce.ui.theme.Gray2

@ExperimentalFoundationApi
@Composable
fun SearchScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = Color.White)
            .wrapContentSize(Alignment.TopCenter)
    ) {
        val inputValue = remember { mutableStateOf(TextFieldValue()) }

        Text(
            modifier = Modifier
                .padding(top = 50.dp, bottom = 21.dp, start = 16.dp, end = 16.dp),
            text = stringResource(R.string.search_shop),
            style = AppTextStyle.title
        )

        Row(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // TODO Use BasicTextField to custom style and remove default padding
            TextField(
                value = inputValue.value,
                onValueChange = {
                    inputValue.value = it
                },
                singleLine = true,
                modifier = Modifier
                    .weight(1f)
                    .background(color = Gray2, shape = RoundedCornerShape(10)),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = null // decorative element
                    )
                },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_clear),
                        contentDescription = null // decorative element
                    )
                },
                textStyle = AppTextStyle.searchField
            )

            Text(
                modifier = Modifier
                    .padding(start = 12.dp),
                text = stringResource(android.R.string.cancel),
                style = AppTextStyle.shopAll
            )
        }

        // Shapes
        Shapes(columnsPerRow = 2, shapes = mockShapes)
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
//    SearchScreen()
}
