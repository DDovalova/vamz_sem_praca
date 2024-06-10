package com.example.vamz_sem_praca.utvary

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

/**
 * Funkcia zobrazuje obrázok s tlačidlom, ktoré slúži na navigáciu na inú obrazovku.
 *
 * @param navController - navigácia medzi obrazovkami v aplikácii
 * @param imageRes - zdroj obrázka
 * @param buttonText - text na tlačidle
 * @param navigateTo - cieľová obrazovka pre navigáciu po kliknutí na tlačidlo
 */
@Composable
fun ObrazokSButtonom(
    navController: NavHostController,
    imageRes: Int,
    buttonText: String,
    navigateTo: String
) {
    val image = painterResource(imageRes)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 1f,
            modifier = Modifier
                .size(300.dp)
                .align(Alignment.Center)
        )
        Button(
            onClick = { navController.navigate(navigateTo) },
            modifier = Modifier
                .align(Alignment.Center)
                .width(200.dp)
                .padding(vertical = 16.dp)
        ) {
            Text(buttonText)
        }
    }
}

/**
 * Funkcia zobrazuje obrázok s textom a prispôsobiteľným tlačidlom pre obľúbené recepty.
 *
 * @param imagePainter - zdroj obrázka
 * @param text - text zobrazený na obrázku
 * @param favoriteButton - funkcia pre tlačidlo obľúbených receptov
 * @param modifier - modifikátor pre prispôsobenie vzhľadu komponentu
 */
@Composable
fun ObrazokSTextomASrdcom(
    imagePainter: Painter,
    text: String,
    favoriteButton: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Image(
            painter = imagePainter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 1f,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(20 / 9f)
        )
        Text(
            text = text,
            fontSize = 50.sp,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold,
            lineHeight = 50.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(10.dp)
        )
        favoriteButton()
        MoreVertButton(modifier = Modifier.align(Alignment.BottomEnd))
    }
}


/**
 * Funkcia zobrazuje obrázok s textom.
 *
 * @param imagePainter - zdroj obrázka
 * @param text - text zobrazený na obrázku
 * @param modifier - modifikátor pre prispôsobenie vzhľadu komponenty
 */
@Composable
fun ObrazokSTextom(
    imagePainter: Painter,
    text: String,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Image(
            painter = imagePainter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 1f,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(7 / 6f)
        )
        Text(
            text = text,
            fontSize = 60.sp,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold,
            lineHeight = 60.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(10.dp)
        )
    }
}
