package com.example.vamz_sem_praca

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.vamz_sem_praca.ui.theme.Vamz_sem_pracaTheme
import com.example.vamz_sem_praca.utvary.VrchnyPanel

class UvodnaStrana {
    @Composable
   fun UvodStrana(
        navController: NavHostController
   ) {
       Column(
           modifier = Modifier
               .statusBarsPadding()
               .padding(horizontal = 10.dp)
               .verticalScroll(rememberScrollState())
               .safeDrawingPadding(),
           verticalArrangement = Arrangement.Top,
           horizontalAlignment = Alignment.CenterHorizontally
       ) {
           VrchnyPanel(nazovStrany = stringResource(R.string.app_name))
           Logo()
           Spacer(modifier = Modifier.height(32.dp))
           StartButton(navController)
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

    @Composable
    fun StartButton(navController: NavHostController) {
        Button(
            onClick = { navController.navigate("hlavnaStrana") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp)
        ) {
            androidx.compose.material3.Text(stringResource(R.string.zaciname))
        }
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