package com.example.vamz_sem_praca.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.vamz_sem_praca.R
import com.example.vamz_sem_praca.ui.theme.Vamz_sem_pracaTheme
import com.example.vamz_sem_praca.utvary.NavigateButton
import com.example.vamz_sem_praca.ui.theme.Mangova

/**
 * Trieda pre úvodnú stránku.
 */
class UvodnaStrana {

    /**
     * Funkcia pre zobrazenie úvodnej stránky.
     *
     * @param navController - navigácia medzi obrazovkami v aplikácii
     */
    @Composable
   fun UvodStrana(
        navController: NavHostController
   ) {
       Column(
           modifier = Modifier
               .statusBarsPadding()
               .padding(horizontal = 0.dp)
               .verticalScroll(rememberScrollState())
               .safeDrawingPadding(),
           verticalArrangement = Arrangement.Top,
           horizontalAlignment = Alignment.CenterHorizontally
       ) {
           VrchnyPanel(nazovStrany = stringResource(R.string.app_name))
           Logo()
           Spacer(modifier = Modifier.height(32.dp))
           NavigateButton(
               navController = navController,
               destination = {"hlavnaStrana"},
               buttonText = stringResource(R.string.zaciname)
           )
       }
   }

    /**
     * Funkcia pre zobrazenie vrchného panelu s názvom stránky.
     *
     * @param nazovStrany - názov stránky
     */
    @Composable
    fun VrchnyPanel(nazovStrany: String) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Mangova)
                .padding(horizontal = 16.dp, vertical = 13.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = nazovStrany,
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }

    /**
     * Funkcia pre zobrazenie loga.
     */
    @Composable
    fun Logo() {
        val image = painterResource(R.drawable.logo)
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(400.dp)
                .aspectRatio(1f)
                .padding(vertical = 24.dp)
        )
    }

    /**
     * Funkcia pre náhľad úvodnej stránky.
     */
    @Preview(showBackground = true)
    @Composable
    fun UvodnaStranaPreview() {
        Vamz_sem_pracaTheme {
           UvodStrana(rememberNavController())
        }
    }
}
