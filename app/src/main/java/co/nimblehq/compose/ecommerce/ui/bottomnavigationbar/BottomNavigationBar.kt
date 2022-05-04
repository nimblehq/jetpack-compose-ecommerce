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
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    navigateToRoute: (String) -> Unit
) {
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Purple700
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            val isSelected =
                (currentRoute == item.route) || (currentRoute?.startsWith(item.route) ?: false)
            BottomNavigationItem(
                icon = {
                    BottomNavigationItemIcon(
                        item = item,
                        selected = isSelected
                    )
                },
                selectedContentColor = Purple600,
                unselectedContentColor = WhiteTrans25,
                alwaysShowLabel = false,
                selected = isSelected,
                onClick = { navigateToRoute(item.route) }
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
    item: BottomNavItem,
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
