package co.nimblehq.compose.ecommerce.ui.setting

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.nimblehq.compose.ecommerce.R
import co.nimblehq.compose.ecommerce.ui.theme.AppTextStyle.settingItem

@ExperimentalFoundationApi
@Composable
fun SettingItem(
    @DrawableRes icon: Int,
    title: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.weight(0.2f),
            painter = painterResource(id = icon),
            contentDescription = null // decorative element
        )

        Text(
            modifier = Modifier.weight(0.7f),
            text = title,
            style = settingItem
        )

        Icon(
            modifier = Modifier
                .weight(0.1f),
            painter = painterResource(id = R.drawable.ic_arrow),
            contentDescription = null
        )
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun SettingItemPreview() {
    SettingItem(
        R.drawable.ic_tab_search,
        "My Orders"
    )
}