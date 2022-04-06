package co.nimblehq.compose.ecommerce.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.*
import androidx.navigation.compose.composable
import co.nimblehq.compose.ecommerce.ui.bottomnavigationbar.BottomNavItem
import co.nimblehq.compose.ecommerce.ui.screen.account.AccountScreen
import co.nimblehq.compose.ecommerce.ui.screen.details.ProductDetail
import co.nimblehq.compose.ecommerce.ui.screen.filter.Filters
import co.nimblehq.compose.ecommerce.ui.screen.home.HomeScreen
import co.nimblehq.compose.ecommerce.ui.screen.product.ProductScreen
import co.nimblehq.compose.ecommerce.ui.screen.search.SearchResultScreen
import co.nimblehq.compose.ecommerce.ui.screen.search.SearchScreen
import co.nimblehq.compose.ecommerce.utils.WindowSize

object NavigationRoute {
    const val MAIN_ROUTE = "main"
    const val HOME_ROUTE = "main/home"
    const val SEARCH_ROUTE = "main/search"
    const val PRODUCT_ROUTE = "main/product"
    const val ACCOUNT_ROUTE = "main/account"

    const val SEARCH_RESULT_ROUTE = "main/search/result"
    const val SEARCH_QUERY_KEY = "query"

    const val PRODUCT_DETAILS_ROUTE = "product"
    const val PRODUCT_ID_KEY = "productId"

    const val FILTERS_ROUTE = "filters"
}

@OptIn(ExperimentalFoundationApi::class)
fun NavGraphBuilder.appNavGraph(
    onProductSelected: (Long, NavBackStackEntry) -> Unit,
    onFilterClick: (NavBackStackEntry) -> Unit,
    onSearchProduct: (String, NavBackStackEntry) -> Unit,
    upPress: () -> Unit,
    windowSize: WindowSize
) {
    navigation(
        route = NavigationRoute.MAIN_ROUTE,
        startDestination = BottomNavItem.Home.route
    ) {
        addMainGraph(
            onProductSelected = onProductSelected,
            onSearchProduct = onSearchProduct,
            windowSize = windowSize
        )
    }
    composable(NavigationRoute.FILTERS_ROUTE) {
        Filters(upPress)
    }
    composable(
        route = "${NavigationRoute.SEARCH_RESULT_ROUTE}/{${NavigationRoute.SEARCH_QUERY_KEY}}",
        arguments = listOf(navArgument(NavigationRoute.SEARCH_QUERY_KEY) {
            type = NavType.StringType
        })
    ) { backStackEntry ->
        val arguments = requireNotNull(backStackEntry.arguments)
        val searchKey = arguments.getString(NavigationRoute.SEARCH_QUERY_KEY)
        SearchResultScreen(
            searchKey = searchKey!!,
            onProductClick = { id -> onProductSelected(id, backStackEntry) },
            onFilterClick = { onFilterClick(backStackEntry) },
            upPress = upPress
        )
    }
    composable(
        route = "${NavigationRoute.PRODUCT_DETAILS_ROUTE}/{${NavigationRoute.PRODUCT_ID_KEY}}",
        arguments = listOf(navArgument(NavigationRoute.PRODUCT_ID_KEY) {
            type = NavType.LongType
        })
    ) { backStackEntry ->
        val arguments = requireNotNull(backStackEntry.arguments)
        val productId = arguments.getLong(NavigationRoute.PRODUCT_ID_KEY)
        ProductDetail(productId = productId, upPress = upPress)
    }
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
fun NavGraphBuilder.addMainGraph(
    onProductSelected: (Long, NavBackStackEntry) -> Unit,
    onSearchProduct: (String, NavBackStackEntry) -> Unit,
    windowSize: WindowSize
) {
    composable(BottomNavItem.Home.route) { backStackEntry ->
        HomeScreen(onProductClick = { id -> onProductSelected(id, backStackEntry) }, windowSize)
    }
    composable(BottomNavItem.Search.route) { backStackEntry ->
        SearchScreen(onSearchProduct = { query -> onSearchProduct(query, backStackEntry) })
    }
    composable(BottomNavItem.Product.route) {
        ProductScreen()
    }
    composable(BottomNavItem.Account.route) {
        AccountScreen()
    }
}
