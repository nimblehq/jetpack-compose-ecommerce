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
