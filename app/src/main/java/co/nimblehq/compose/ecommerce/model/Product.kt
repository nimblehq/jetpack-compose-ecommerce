package co.nimblehq.compose.ecommerce.model

import androidx.annotation.DrawableRes
import co.nimblehq.compose.ecommerce.R

data class Product(
        val id: Long,
        val name: String,
        val price: Long,
        @DrawableRes val image: Int
)

val mockPopularProducts = listOf(
        Product(
                id = 1,
                name = "Pink Cube",
                price = 8000,
                image = R.drawable.ic_shirt_pink_cube
        ),
        Product(
                id = 2,
                name = "Honey Ico",
                price = 5000,
                image = R.drawable.ic_shirt_honey_ico
        )
)

val mockNewArrivalsProducts = listOf(
        Product(
                id = 1,
                name = "Indigo Shuzan",
                price = 8000,
                image = R.drawable.ic_shirt_indigo_shuzan
        ),
        Product(
                id = 2,
                name = "Gray Taurus",
                price = 5000,
                image = R.drawable.ic_shirt_gray_taurus
        )
)

val mockForYouProducts = listOf(
        Product(
                id = 1,
                name = "Pink Cylinder",
                price = 5000,
                image = R.drawable.ic_shirt_pink_cylinder
        ),
        Product(
                id = 2,
                name = "Gray Cube",
                price = 8000,
                image = R.drawable.ic_shirt_gray_cube
        ),
        Product(
                id = 3,
                name = "Honey Ico",
                price = 5000,
                image = R.drawable.ic_shirt_honey_ico
        ),
        Product(
                id = 4,
                name = "Indigo Cube",
                price = 8000,
                image = R.drawable.ic_shirt_indigo_cube
        )
)

val mockMoreCubesProducts = listOf(
        Product(
                id = 1,
                name = "Indigo Cube",
                price = 8000,
                image = R.drawable.ic_shirt_indigo_cube
        ),
        Product(
                id = 2,
                name = "Honey Cube",
                price = 5000,
                image = R.drawable.ic_shirt_honey_cube
        )
)

val mockSearchResultProducts = listOf(
        Product(
                id = 1,
                name = "Pink Cube",
                price = 10000,
                image = R.drawable.ic_shirt_pink_cube
        ),
        Product(
                id = 2,
                name = "Gray Cube",
                price = 10000,
                image = R.drawable.ic_shirt_gray_cube
        ),
        Product(
                id = 3,
                name = "Indigo Cube",
                price = 8000,
                image = R.drawable.ic_shirt_indigo_cube
        ),
        Product(
                id = 4,
                name = "Honey Cube",
                price = 8000,
                image = R.drawable.ic_shirt_honey_cube
        )
)
