package co.nimblehq.compose.ecommerce.ui.collection

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import co.nimblehq.compose.ecommerce.R
import co.nimblehq.compose.ecommerce.model.categories
import co.nimblehq.compose.ecommerce.ui.category.Categories
import co.nimblehq.compose.ecommerce.ui.theme.AppTextStyle
import co.nimblehq.compose.ecommerce.ui.theme.Blue
import co.nimblehq.compose.ecommerce.ui.theme.Purple600

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Collection(
    showOnePanel: Boolean
) {
    val itemMaxWidth = (LocalConfiguration.current.screenWidthDp.dp) / 2
    if (showOnePanel) {
        // Suggested for you
        SuggestedForYouCard(Modifier.fillMaxWidth())
        // Category
        Categories(horizontalScroll = true, maxWidth = Dp.Infinity, categories = categories)
    } else {
        Row {
            // Suggested for you
            SuggestedForYouCard(Modifier.width(itemMaxWidth))
            // Category
            Categories(false, maxWidth = itemMaxWidth, categories = categories)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SuggestedForYouCard(modifier: Modifier) {
    val shape = RoundedCornerShape(12.dp)

    ConstraintLayout(
        modifier = modifier
            .height(386.dp)
            .padding(horizontal = 16.dp)
            .clip(shape)
            .background(Blue)
    ) {
        val (tvSuggestForYou, tvCollection, tvPrice, btShop, sDivider, ivShirt, tvPoly) = createRefs()

        // FIXME Correct the image to match design
        Image(
            modifier = Modifier
                .constrainAs(ivShirt) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
                .size(419.dp, 378.dp)
                .padding(top = 92.dp, start = 32.dp),
            painter = painterResource(id = R.drawable.ic_shirt),
            contentDescription = "collection"
        )

        Text(
            modifier = Modifier
                .constrainAs(tvSuggestForYou) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .padding(top = 16.dp, start = 16.dp),
            text = stringResource(R.string.home_suggested_for_you),
            style = AppTextStyle.tagline
        )

        Text(
            modifier = Modifier
                .constrainAs(tvCollection) {
                    top.linkTo(tvSuggestForYou.bottom)
                    start.linkTo(tvSuggestForYou.start)
                }
                .padding(top = 4.dp, start = 16.dp, end = 16.dp),
            text = stringResource(R.string.home_collection),
            style = AppTextStyle.collection
        )

        // Work around to display the divider with padding
        Column(modifier = Modifier
            .padding(horizontal = 16.dp)
            .constrainAs(sDivider) {
                bottom.linkTo(btShop.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Spacer(
                modifier = Modifier
                    .background(Color.White.copy(alpha = 0.33f))
                    .height(0.5.dp)
                    .fillMaxWidth() // FIXME Padding horizontal doesn't work
            )
        }

        Text(
            modifier = Modifier
                .constrainAs(tvPoly) {
                    bottom.linkTo(tvPrice.top)
                    start.linkTo(tvPrice.start)
                }
                .padding(start = 16.dp),
            text = stringResource(R.string.home_product_name),
            style = AppTextStyle.productName
        )

        Text(
            modifier = Modifier
                .constrainAs(tvPrice) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                }
                .padding(start = 16.dp, bottom = 16.dp),
            text = stringResource(R.string.home_product_price),
            style = AppTextStyle.productPrice
        )

        Surface(
            modifier = Modifier
                .constrainAs(btShop) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                }
                .padding(16.dp),
            color = Purple600,
            shape = RoundedCornerShape(17.dp),
            role = Role.Button,
            onClick = { /*TODO*/ }
        ) {
            Text(
                text = stringResource(R.string.home_action_shop),
                style = AppTextStyle.shop,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 5.dp)
            )
        }
    }
}