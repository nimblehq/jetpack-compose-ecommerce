package co.nimblehq.compose.ecommerce.ui.screen.filter

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.nimblehq.compose.ecommerce.R
import co.nimblehq.compose.ecommerce.ui.theme.AppTextStyle
import co.nimblehq.compose.ecommerce.ui.theme.Gray5
import co.nimblehq.compose.ecommerce.ui.theme.Purple600

@ExperimentalFoundationApi
@Preview
@Composable
fun Filters() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = R.string.filters_title),
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    TextButton(onClick = {}) {
                        Text(
                            text = stringResource(id = R.string.filters_close)
                        )
                    }
                },
                actions = {
                    TextButton(onClick = {}) {
                        Text(
                            stringResource(id = R.string.filters_reset)
                        )
                    }
                },
                backgroundColor = Color.White
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(horizontal = 16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .align(Alignment.TopCenter),
            ) {

                // Sort by
                Text(
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(bottom = 10.dp, top = 20.dp),
                    text = stringResource(id = R.string.filters_sort_by),
                    style = AppTextStyle.filterHeader
                )

                SortByItem(
                    radioOptions = listOf(
                        stringResource(id = R.string.filters_sort_by_new) to "",
                        stringResource(id = R.string.filters_sort_by_price) to stringResource(id = R.string.filters_sort_by_price_high_to_low),
                        stringResource(id = R.string.filters_sort_by_price) to stringResource(id = R.string.filters_sort_by_price_low_to_high)
                    )
                )

                // Filter by
                Text(
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(bottom = 10.dp, top = 20.dp),
                    text = stringResource(id = R.string.filters_filter_by),
                    style = AppTextStyle.filterHeader
                )

                FilterByItem(
                    stringResource(id = R.string.filters_filter_by_categories)
                )

                FilterByItem(
                    stringResource(id = R.string.filters_filter_by_colors)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            ) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, bottom = 40.dp)
                        .align(Alignment.CenterHorizontally),
                    onClick = {},
                    enabled = true
                ) {
                    Text(
                        modifier = Modifier.padding(vertical = 6.dp),
                        text = stringResource(id = R.string.filters_view_results),
                        style = AppTextStyle.productViewResult
                    )
                }
            }
        }
    }
}

@Composable
fun SortByItem(
    radioOptions: List<Pair<String, String>>
) {
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0].first) }
    radioOptions.forEach { (title, description) ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .selectable(
                    selected = (title == selectedOption),
                    onClick = { onOptionSelected(title) }
                )
        ) {
            Text(
                modifier = Modifier
                    .weight(0.2f)
                    .align(Alignment.CenterVertically),
                text = title,
                textAlign = TextAlign.Start,
                style = AppTextStyle.filterItem
            )

            Text(
                modifier = Modifier
                    .weight(0.7f)
                    .align(Alignment.CenterVertically),
                text = description,
                textAlign = TextAlign.Start,
                style = AppTextStyle.filterDescription
            )
            RadioButton(
                modifier = Modifier
                    .weight(0.1f)
                    .align(Alignment.CenterVertically),
                colors = RadioButtonDefaults.colors(
                    selectedColor = Purple600,
                    unselectedColor = Purple600
                ),
                selected = (title == selectedOption),
                onClick = {
                    onOptionSelected(title)
                }
            )
        }

        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = Gray5,
            thickness = 1.dp
        )
    }
}

@Composable
fun FilterByItem(
    text: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(0.9f),
            text = text,
            style = AppTextStyle.settingItem
        )

        Icon(
            modifier = Modifier
                .weight(0.1f),
            painter = painterResource(id = R.drawable.ic_arrow),
            contentDescription = null
        )
    }

    Divider(
        modifier = Modifier.fillMaxWidth(),
        color = Gray5,
        thickness = 1.dp
    )
}
