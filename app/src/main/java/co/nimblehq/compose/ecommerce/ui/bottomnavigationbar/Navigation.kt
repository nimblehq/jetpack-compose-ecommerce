package co.nimblehq.compose.ecommerce.ui.bottomnavigationbar

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import co.nimblehq.compose.ecommerce.ui.screen.account.AccountScreen
import co.nimblehq.compose.ecommerce.ui.screen.home.HomeScreen
import co.nimblehq.compose.ecommerce.ui.screen.product.ProductScreen
import co.nimblehq.compose.ecommerce.ui.screen.search.SearchScreen
import co.nimblehq.compose.ecommerce.utils.WindowSize

@ExperimentalFoundationApi
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Navigation(navHostController: NavHostController, windowSize: WindowSize) {
    NavHost(
        navController = navHostController,
        startDestination = NavigationItem.Home.route
    ) {
        composable(NavigationItem.Home.route) {
            HomeScreen(windowSize)
        }
        composable(NavigationItem.Search.route) {
            SearchScreen()
        }
        composable(NavigationItem.Product.route) {
            ProductScreen()
        }
        composable(NavigationItem.Account.route) {
            AccountScreen()
        }
    }
}
