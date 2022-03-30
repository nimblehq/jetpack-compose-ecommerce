package co.nimblehq.compose.ecommerce.ui.screen.account

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import co.nimblehq.compose.ecommerce.R
import co.nimblehq.compose.ecommerce.ui.setting.SettingItem
import co.nimblehq.compose.ecommerce.ui.theme.AppTextStyle
import co.nimblehq.compose.ecommerce.ui.theme.Gray5

@ExperimentalFoundationApi
@Composable
fun AccountScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {

        Text(
            modifier = Modifier
                .padding(top = 50.dp, bottom = 21.dp, start = 16.dp, end = 16.dp),
            text = stringResource(R.string.settings_my_account),
            style = AppTextStyle.title
        )

        // Profile
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 20.dp)
        ) {
            val (ivAvatar, tvFullName, tvEmail, ivArrow) = createRefs()

            Image(
                modifier = Modifier
                    .constrainAs(ivAvatar) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                    }
                    .size(60.dp, 60.dp)
                    .clip(CircleShape),
                painter = painterResource(id = R.drawable.ic_profile_avatar),
                contentDescription = null
            )

            Text(
                modifier = Modifier
                    .constrainAs(tvFullName) {
                        start.linkTo(ivAvatar.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(tvEmail.top)
                    }
                    .padding(start = 12.dp),
                text = "Joseph Edmed",
                style = AppTextStyle.settingFullName
            )

            Text(
                modifier = Modifier
                    .constrainAs(tvEmail) {
                        start.linkTo(ivAvatar.end)
                        top.linkTo(tvFullName.bottom)
                        bottom.linkTo(tvEmail.top)
                    }
                    .padding(start = 12.dp),
                text = "josephed@mail.com",
                style = AppTextStyle.settingEmail
            )

            Icon(
                modifier = Modifier
                    .constrainAs(ivArrow) {
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    },
                painter = painterResource(id = R.drawable.ic_arrow),
                contentDescription = null
            )
        }


        // My Order
        Text(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 16.dp, bottom = 10.dp, top = 18.dp),
            text = stringResource(id = R.string.settings_my_order),
            style = AppTextStyle.productDetailHeader
        )

        SettingItem(
            icon = R.drawable.ic_setting_my_orders,
            title = stringResource(id = R.string.settings_my_orders)
        )

        Divider(
            modifier = Modifier.padding(start = 16.dp),
            color = Gray5,
            thickness = 1.dp
        )

        SettingItem(
            icon = R.drawable.ic_setting_my_returns,
            title = stringResource(id = R.string.settings_my_returns)
        )

        // My Addresses
        Text(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 16.dp, top = 28.dp, bottom = 10.dp),
            text = stringResource(id = R.string.settings_my_addresses),
            style = AppTextStyle.productDetailHeader
        )

        SettingItem(
            icon = R.drawable.ic_setting_shipping_address,
            title = stringResource(id = R.string.settings_shipping_address)
        )

        Divider(
            modifier = Modifier.padding(start = 16.dp),
            color = Gray5,
            thickness = 1.dp
        )

        SettingItem(
            icon = R.drawable.ic_setting_billing_address,
            title = stringResource(id = R.string.settings_billing_address)
        )

        Divider(
            modifier = Modifier.padding(start = 16.dp),
            color = Gray5,
            thickness = 1.dp
        )

        SettingItem(
            icon = R.drawable.ic_setting_tax_invoice_address,
            title = stringResource(id = R.string.settings_tax_invoice_address)
        )

        SettingItem(
            icon = R.drawable.ic_setting_my_wish_list,
            title = stringResource(id = R.string.settings_my_wishlist)
        )

        SettingItem(
            icon = R.drawable.ic_setting_log_out,
            title = stringResource(id = R.string.settings_log_out)
        )
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun AccountScreenPreview() {
    AccountScreen()
}
