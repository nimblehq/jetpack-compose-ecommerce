package co.nimblehq.compose.ecommerce.ui.bottomnavigationbar

import androidx.annotation.DrawableRes
import co.nimblehq.compose.ecommerce.R
import co.nimblehq.compose.ecommerce.navigation.NavigationRoute

val bottomNavItems = listOf(
    BottomNavItem.Home,
    BottomNavItem.Search,
    BottomNavItem.Product,
    BottomNavItem.Account
)

sealed class BottomNavItem(
    val route: String,
    @DrawableRes val iconResId: Int,
    @DrawableRes val selectedIconResId: Int,
    val title: String
) {
    object Home : BottomNavItem(
        route = NavigationRoute.HOME_ROUTE,
        iconResId = R.drawable.ic_tab_home,
        selectedIconResId = R.drawable.ic_tab_home_selected,
        title = "Home"
    )

    object Search : BottomNavItem(
        route = NavigationRoute.SEARCH_ROUTE,
        iconResId = R.drawable.ic_tab_search,
        selectedIconResId = R.drawable.ic_tab_search_selected,
        title = "Search"
    )

    object Product : BottomNavItem(
        route = NavigationRoute.PRODUCT_ROUTE,
        iconResId = R.drawable.ic_tab_product,
        selectedIconResId = R.drawable.ic_tab_product_selected,
        title = "Product"
    )

    object Account : BottomNavItem(
        route = NavigationRoute.ACCOUNT_ROUTE,
        iconResId = R.drawable.ic_tab_account,
        selectedIconResId = R.drawable.ic_tab_account_selected,
        title = "Account"
    )
}
