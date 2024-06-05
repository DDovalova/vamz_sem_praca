package com.example.vamz_sem_praca

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.vamz_sem_praca.ui.theme.Vamz_sem_pracaTheme

class UvodnaStrana {
    /*object UvodnaStranaDestination : NavCiel {
        override val cesta = "uvodna_strana" //override
        override val nazovZdroja = R.string.app_name
    }*/

    @Composable
   fun UvodStrana(
        navController: NavHostController
        //navigateToObed: () -> Unit,
        //navigateToObedUpdate: (Int) -> Unit,
       // modifier: Modifier = Modifier
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
           VrchnyPanel()
           Logo()
           Spacer(modifier = Modifier.height(32.dp))
           StartButton(navController)

       }
   }

    @Composable
    fun VrchnyPanel() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Menu, contentDescription = "Menu")
            }
            androidx.compose.material3.Text(
                text = stringResource(R.string.app_name),
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

    @Composable
    fun StartButton(navController: NavHostController) { //navigateToObed: () -> Unit
        Button(
            onClick = { navController.navigate("hlavnaStrana") }, //navigateToObed()
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
           UvodStrana(rememberNavController()) //navigateToObed = {}, navigateToObedUpdate = {}
        }
    }
}
 //androidx.compose.material3.