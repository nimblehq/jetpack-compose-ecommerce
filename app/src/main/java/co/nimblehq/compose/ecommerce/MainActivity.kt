package co.nimblehq.compose.ecommerce

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import co.nimblehq.compose.ecommerce.navigation.NavigationRoute
import co.nimblehq.compose.ecommerce.navigation.appNavGraph
import co.nimblehq.compose.ecommerce.ui.bottomnavigationbar.BottomNavigationBar
import co.nimblehq.compose.ecommerce.ui.bottomnavigationbar.bottomNavItems
import co.nimblehq.compose.ecommerce.utils.WindowSize
import co.nimblehq.compose.ecommerce.utils.rememberWindowSizeClass

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, true)

        setContent {
            val windowSize = rememberWindowSizeClass()
            MainScreen(windowSize)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(windowSize: WindowSize) {
    val appState = rememberEcommerceAppState()
    Scaffold(
        bottomBar = {
            if (appState.shouldShowBottomBar) {
                BottomNavigationBar(
                    items = bottomNavItems,
                    navController = appState.navController,
                    navigateToRoute = appState::navigateToBottomBarRoute
                )
            }
        }
    ) { innerPadding ->
        // Fix the BottomNavigation bar overlap the content https://stackoverflow.com/a/66574166
        Box(modifier = Modifier.padding(innerPadding)) {
            NavHost(
                navController = appState.navController,
                startDestination = NavigationRoute.MAIN_ROUTE
            ) {
                appNavGraph(
                    onProductSelected = appState::navigateToProductDetail,
                    onSearchProduct = appState::navigateToSearchResult,
                    onFilterClick = appState::navigateToFilters,
                    upPress = appState::upPress,
                    windowSize = windowSize
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
//    MainScreen(windowSizeClass)
}
