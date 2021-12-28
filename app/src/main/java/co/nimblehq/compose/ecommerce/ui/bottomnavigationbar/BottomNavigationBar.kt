package co.nimblehq.compose.ecommerce.ui.bottomnavigationbar

import androidx.compose.animation.Crossfade
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import co.nimblehq.compose.ecommerce.ui.theme.Purple600
import co.nimblehq.compose.ecommerce.ui.theme.Purple700
import co.nimblehq.compose.ecommerce.ui.theme.WhiteTrans25

@Composable
fun BottomNavigationBar(items: List<NavigationItem>, navController: NavController) {
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Purple700
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    BottomNavigationItemIcon(
                        item = item,
                        selected = currentRoute == item.route
                    )
                },
                selectedContentColor = Purple600,
                unselectedContentColor = WhiteTrans25,
                alwaysShowLabel = false,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
//    BottomNavigationBar()
}


@Composable
fun BottomNavigationItemIcon(
    item: NavigationItem,
    selected: Boolean
) {
    val icon = painterResource(item.iconResId)
    val selectedIcon = painterResource(item.selectedIconResId)

    Crossfade(targetState = selected) {
        Icon(
            painter = if (it) selectedIcon else icon,
            contentDescription = item.title,
        )
    }
}
