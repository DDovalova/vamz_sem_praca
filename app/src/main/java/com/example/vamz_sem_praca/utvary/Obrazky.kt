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

@Composable
fun ObrazokSTextom(
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
            //fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold,
            lineHeight = 50.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(10.dp)
        )
        //SrdceButton()
        favoriteButton()
        MoreVertButton(modifier = Modifier.align(Alignment.BottomEnd))
    }
}