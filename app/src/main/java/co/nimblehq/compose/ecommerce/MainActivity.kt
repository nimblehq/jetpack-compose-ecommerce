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
import androidx.navigation.compose.rememberNavController
import co.nimblehq.compose.ecommerce.ui.bottomnavigationbar.BottomNavigationBar
import co.nimblehq.compose.ecommerce.ui.bottomnavigationbar.Navigation
import co.nimblehq.compose.ecommerce.ui.bottomnavigationbar.NavigationItem
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
    val navController = rememberNavController()
    val tabItems = listOf(
        NavigationItem.Home,
        NavigationItem.Search,
        NavigationItem.Product,
        NavigationItem.Account
    )
    Scaffold(
        bottomBar = { BottomNavigationBar(items = tabItems, navController = navController) }
    ) { innerPadding ->
        // Fix the BottomNavigation bar overlap the content https://stackoverflow.com/a/66574166
        Box(modifier = Modifier.padding(innerPadding)) {
            Navigation(navController, windowSize)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
//    MainScreen(windowSizeClass)
}
