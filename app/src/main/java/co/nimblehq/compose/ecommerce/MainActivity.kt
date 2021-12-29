package co.nimblehq.compose.ecommerce

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import co.nimblehq.compose.ecommerce.ui.bottomnavigationbar.BottomNavigationBar
import co.nimblehq.compose.ecommerce.ui.bottomnavigationbar.Navigation
import co.nimblehq.compose.ecommerce.ui.bottomnavigationbar.NavigationItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, true)

        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val tabItems = listOf(
        NavigationItem.Home,
        NavigationItem.Search,
        NavigationItem.Product,
        NavigationItem.Account
    )
    Scaffold(
        bottomBar = { BottomNavigationBar(items = tabItems, navController = navController) }
    ) {
        Navigation(navController)
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}
