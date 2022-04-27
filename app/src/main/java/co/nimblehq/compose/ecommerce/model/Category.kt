package co.nimblehq.compose.ecommerce.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import co.nimblehq.compose.ecommerce.R

@Immutable
data class Category(
    val id: Long,
    val name: String,
    @DrawableRes val image: Int
)

val categories = listOf(
    Category(
        id = 1L,
        name = "Cube",
        image = R.drawable.ic_category_cube
    ),
    Category(
        id = 2L,
        name = "Sphere",
        image = R.drawable.ic_category_sphere
    ),
    Category(
        id = 3L,
        name = "Shuzan",
        image = R.drawable.ic_category_shuzan
    ),
    Category(
        id = 4L,
        name = "Ico",
        image = R.drawable.ic_category_ico
    ),
    Category(
        id = 5L,
        name = "Taurus",
        image = R.drawable.ic_category_taurus
    ),
    Category(
        id = 6L,
        name = "Cylinder",
        image = R.drawable.ic_category_cylinder
    )
)
