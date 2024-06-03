package com.example.vamz_sem_praca

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vamz_sem_praca.ui.theme.Vamz_sem_pracaTheme

class Obed {
    @Composable
        fun Text() {
            Column(
                modifier = Modifier
                    .statusBarsPadding()
                    .padding(horizontal = 40.dp)
                    .verticalScroll(rememberScrollState())
                    .safeDrawingPadding(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top //Center
            ) {
                /*Text(
                    text = stringResource(R.string.paradajkova_polievka),
                    style = MaterialTheme.typography.displaySmall,
                    modifier = Modifier
                        .padding(bottom = 16.dp, top = 40.dp)
                        .align(alignment = Alignment.Start)
                )*/
                Spacer(modifier = Modifier.height(110.dp))
                Text(
                    text = stringResource(R.string.paradajkova_polievka),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 116.sp,
                    textAlign = TextAlign.Start
                )
            }
        }

        @Composable
        fun Obrazok() {
            val image = painterResource(R.drawable.paradaj_p)

            Box() {
                Image(
                    painter = image,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    alpha = 1f,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 90.dp)
                )
                Text(
                    text = stringResource(R.string.obed),
                    fontSize = 50.sp,
                    modifier = Modifier
                        .align(alignment = Alignment.TopCenter)
                        .background(Color.Yellow)
                        .fillMaxWidth()
                        .padding(
                            top = 24.dp,
                            start = 130.dp
                        )
                )
            }
        }

    @Preview(showBackground = true)
    @Composable
    fun KategoriePreview() {
        Vamz_sem_pracaTheme {
            Obrazok()
            Text()

        }
    }
}