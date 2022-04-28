package co.nimblehq.compose.ecommerce.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

// TODO Create FontFamily for the text styles
object AppTextStyle {
    val title = TextStyle(
        fontWeight = FontWeight.Bold,
        color = Gray,
        textAlign = TextAlign.Center,
        fontSize = 34.sp
    )

    val badge = TextStyle(
        color = Color.White,
        fontSize = 11.sp,
        fontWeight = FontWeight.Normal
    )

    val tagline = TextStyle(
        fontWeight = FontWeight.SemiBold,
        color = Color(0x99FFFFFF),
        textAlign = TextAlign.Center,
        fontSize = 13.sp,
    )

    val collection = TextStyle(
        fontWeight = FontWeight.Bold,
        color = Color.White,
        textAlign = TextAlign.Start,
        fontSize = 28.sp
    )

    val productName = TextStyle(
        fontWeight = FontWeight.SemiBold,
        color = Color.White,
        textAlign = TextAlign.Center,
        fontSize = 17.sp
    )

    val productPrice = TextStyle(
        fontWeight = FontWeight.Normal,
        color = Color.White,
        textAlign = TextAlign.Center,
        fontSize = 13.sp
    )

    val productItemName = TextStyle(
        fontWeight = FontWeight.SemiBold,
        color = Gray,
        textAlign = TextAlign.Center,
        fontSize = 17.sp
    )

    val productItemPrice = TextStyle(
        fontWeight = FontWeight.Normal,
        color = Gray,
        textAlign = TextAlign.Center,
        fontSize = 13.sp
    )

    val productSectionHeader = TextStyle(
        color = Gray,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center,
        fontSize = 22.sp,
    )

    val shop = TextStyle(
        color = Color.White,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center,
        fontSize = 15.sp,
    )

    val shopAll = TextStyle(
        color = Purple600,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Center,
        fontSize = 15.sp,
    )

    val category = TextStyle(
        fontWeight = FontWeight.Normal,
        color = Gray,
        textAlign = TextAlign.Center,
        fontSize = 13.sp
    )

    val searchField = TextStyle(
        color = Gray,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Start,
        fontSize = 17.sp,
    )

    val productDetailHeader = TextStyle(
        color = Gray,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center,
        fontSize = 22.sp,
    )

    val productDetailAbout = TextStyle(
        color = Gray3,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Start,
        fontSize = 17.sp,
    )

    val productSize = TextStyle(
        color = Gray3,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Center,
        fontSize = 17.sp,
    )

    val productDetailName = TextStyle(
        color = Gray,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center,
        fontSize = 28.sp,
    )

    val productDetailPrice = TextStyle(
        color = Gray,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Center,
        fontSize = 22.sp,
    )

    val productDetailAddToCart = TextStyle(
        color = Color.White,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center,
        fontSize = 17.sp,
    )
}
