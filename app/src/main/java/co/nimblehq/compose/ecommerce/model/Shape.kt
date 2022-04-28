package co.nimblehq.compose.ecommerce.model

import androidx.annotation.DrawableRes
import co.nimblehq.compose.ecommerce.R

data class Shape(
    val id: Long,
    val name: String,
    val numberOfItem: Int,
    @DrawableRes val image: Int
)

val mockShapes = listOf(
    Shape(
        id = 1,
        name = "Cube",
        numberOfItem = 4,
        image = R.drawable.ic_category_cube_large
    ),
    Shape(
        id = 2,
        name = "Sphere",
        numberOfItem = 4,
        image = R.drawable.ic_category_sphere_large
    ),
    Shape(
        id = 3,
        name = "Shuzam",
        numberOfItem = 4,
        image = R.drawable.ic_category_shuzam_large
    ),
    Shape(
        id = 4,
        name = "Ico",
        numberOfItem = 4,
        image = R.drawable.ic_category_ico_large
    ),
    Shape(
        id = 5,
        name = "Taurus",
        numberOfItem = 0,
        image = R.drawable.ic_category_taurus_large
    ),
    Shape(
        id = 6,
        name = "Cylinder",
        numberOfItem = 1,
        image = R.drawable.ic_category_cylinder_large
    )
)