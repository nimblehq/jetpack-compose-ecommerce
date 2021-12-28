package co.nimblehq.compose.ecommerce.ui.bottomnavigationbar

import androidx.annotation.DrawableRes
import co.nimblehq.compose.ecommerce.R

sealed class NavigationItem(
    val route: String,
    @DrawableRes val iconResId: Int,
    @DrawableRes val selectedIconResId: Int,
    val title: String
) {
    object Home : NavigationItem(
        route = "home",
        iconResId = R.drawable.ic_tab_home,
        selectedIconResId = R.drawable.ic_tab_home_selected,
        title = "Home"
    )

    object Search : NavigationItem(
        route = "search",
        iconResId = R.drawable.ic_tab_search,
        selectedIconResId = R.drawable.ic_tab_search_selected,
        title = "Search"
    )

    object Product : NavigationItem(
        route = "product",
        iconResId = R.drawable.ic_tab_product,
        selectedIconResId = R.drawable.ic_tab_product_selected,
        title = "Product"
    )

    object Account : NavigationItem(
        route = "account",
        iconResId = R.drawable.ic_tab_account,
        selectedIconResId = R.drawable.ic_tab_account_selected,
        title = "Account"
    )
}
