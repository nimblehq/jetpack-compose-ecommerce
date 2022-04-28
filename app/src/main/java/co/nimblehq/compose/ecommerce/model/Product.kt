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
                image = R.drawable.ic_shirt
        ),
        Product(
                id = 2,
                name = "Honey Ico",
                price = 5000,
                image = R.drawable.ic_shirt
        )
)
