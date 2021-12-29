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

    val shop = TextStyle(
        color = Color.White,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center,
        fontSize = 15.sp,
    )
}
