package com.example.vamz_sem_praca

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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.vamz_sem_praca.ui.theme.Vamz_sem_pracaTheme
import com.example.vamz_sem_praca.utvary.NavigateButton

class UvodnaStrana {
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
               destination = "hlavnaStrana",
               buttonText = stringResource(R.string.zaciname)
           )
       }
   }

    @Composable
    fun VrchnyPanel(nazovStrany: String) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Green)
                .padding(horizontal = 16.dp, vertical = 13.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = nazovStrany,
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }

    @Composable
    fun Logo() {
        val image = painterResource(R.drawable.logo)
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .aspectRatio(1f)
                .padding(vertical = 24.dp)
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun UvodnaStranaPreview() {
        Vamz_sem_pracaTheme {
           UvodStrana(rememberNavController())
        }
    }
}
 //androidx.compose.material3.