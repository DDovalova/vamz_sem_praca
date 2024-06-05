package com.example.vamz_sem_praca

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.vamz_sem_praca.ui.theme.Vamz_sem_pracaTheme
import com.example.vamz_sem_praca.utvary.VrchnyPanel

class Obed {
    @Composable
    fun ObedStrana(
        navController: NavHostController
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .verticalScroll(rememberScrollState())
                .safeDrawingPadding()
                .padding(horizontal = 10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            VrchnyPanel(nazovStrany = stringResource(R.string.obed))
            Obrazok()
            StartButton()
            PlusButton(navController)
        }
    }

    @Composable
    fun Obrazok() {
        val image = painterResource(R.drawable.paradaj_p)
        Box {
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alpha = 1f,
                modifier = Modifier
                    .fillMaxWidth()
        )
       Text(
            text = stringResource(R.string.paradajkova_polievka),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 60.dp)
        )
    }
}

    @Composable
    fun StartButton() {
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
        ) {
            Text(stringResource(R.string.paradajkova_polievka))
        }
    }

    @Composable
    fun PlusButton(navController: NavHostController) {
        FloatingActionButton(
            onClick = { navController.navigate("novyRecept")},
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
               .padding(top = 480.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = stringResource(R.string.vytvorit)
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ObedPreview() {
        Vamz_sem_pracaTheme {
            ObedStrana(rememberNavController())
        }
    }
}
