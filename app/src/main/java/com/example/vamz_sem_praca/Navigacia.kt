package com.example.vamz_sem_praca

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.annotation.StringRes
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vamz_sem_praca.utvary.MenuPanel

@Composable
fun Navigacia() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    MenuPanel(navController = navController, drawerState = drawerState)

    NavHost(navController = navController, startDestination = "uvodnaStrana") {
        composable("uvodnaStrana") { UvodnaStrana().UvodStrana(navController) }
        composable("hlavnaStrana") { HlavnaStrana().HlStrana(navController) }
        composable("ranajky") { Ranajky().RanajkyStrana(navController) }
        composable("obed") { Obed().ObedStrana(navController) }
        //composable("vecera") { Vecera().VeceraStrana(navController) }
        //composable("dezert") { Dezert().DezertStrana(navController) }
        composable("prevodGnaH") { PrevodGnaH().PrevodJednotiekGram() }
        composable("prevodHnaG") { PrevodHnaG().PrevodJednotiekHrncek() }
        composable("novyRecept") { NovyRecept().VytvorRecepty(navController) }
    }
}
