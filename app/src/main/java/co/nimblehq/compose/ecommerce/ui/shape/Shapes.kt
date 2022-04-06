package co.nimblehq.compose.ecommerce.ui.shape

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import co.nimblehq.compose.ecommerce.R
import co.nimblehq.compose.ecommerce.model.Shape
import co.nimblehq.compose.ecommerce.model.mockShapes
import co.nimblehq.compose.ecommerce.ui.theme.AppTextStyle
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode

@ExperimentalFoundationApi
@Composable
fun Shapes(
    columnsPerRow: Int,
    shapes: List<Shape>,
    onShapeClick: (String) -> Unit
) {
    val itemPadding = 16.dp
    Column(
        modifier = Modifier.padding(horizontal = itemPadding)
    ) {
        // Workaround solution: https://medium.com/tech-takeaways/scrollable-grid-view-with-jetpack-compose-aed9f2b9c382
        val itemMaxWidth =
            (LocalConfiguration.current.screenWidthDp.dp - (itemPadding * 2)) / columnsPerRow
        FlowRow(
            mainAxisSize = SizeMode.Expand,
            mainAxisAlignment = FlowMainAxisAlignment.SpaceEvenly
        ) {
            shapes.forEachIndexed { index, shape ->
                val modifier = if (index % 2 == 0) {
                    Modifier
                        .requiredWidth(itemMaxWidth)
                        .padding(end = 8.dp)
                } else {
                    Modifier
                        .requiredWidth(itemMaxWidth)
                        .padding(start = 8.dp)
                }
                ShapeItem(
                    modifier = modifier.clickable {
                        onShapeClick(shape.name)
                    },
                    shape
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun ShapesPreview() {
    Shapes(
        columnsPerRow = 2,
        shapes = mockShapes
    ) {}
}

@Composable
fun ShapeItem(
    modifier: Modifier,
    shape: Shape
) {
    ConstraintLayout(modifier = modifier.padding(bottom = 8.dp)) {
        val (ivShape, tvShapeName, tvNumberOfItem) = createRefs()

        Image(
            modifier = Modifier
                .constrainAs(ivShape) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                },
            painter = painterResource(id = shape.image), contentDescription = null
        )

        Text(
            modifier = Modifier
                .constrainAs(tvShapeName) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(ivShape.bottom)
                }
                .padding(top = 8.dp),
            style = AppTextStyle.productItemName,
            text = shape.name
        )

        Text(
            modifier = Modifier.constrainAs(tvNumberOfItem) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(tvShapeName.bottom)
            },
            style = AppTextStyle.productItemPrice,
            text = LocalContext.current.resources.getQuantityString(
                R.plurals.search_shape_total_item,
                shape.numberOfItem,
                shape.numberOfItem
            )
        )
    }
}

@Composable
@Preview
fun ProductItemPreview() {
    ShapeItem(
        Modifier.fillMaxWidth(),
        Shape(
            id = 1,
            name = "Cube",
            numberOfItem = 4,
            image = R.drawable.ic_shirt_honey_cube
        )
    )
}