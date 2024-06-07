package com.example.vamz_sem_praca.navigacia

import androidx.compose.runtime.Composable
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vamz_sem_praca.data.FavReceptyViewModel
import com.example.vamz_sem_praca.data.HladajReceptyViewModel
import com.example.vamz_sem_praca.screens.Dezert
import com.example.vamz_sem_praca.screens.HlavnaStrana
import com.example.vamz_sem_praca.screens.NovyRecept
import com.example.vamz_sem_praca.screens.Obed
import com.example.vamz_sem_praca.screens.OblubeneRecepty
import com.example.vamz_sem_praca.screens.PrevodGnaH
import com.example.vamz_sem_praca.screens.PrevodHnaG
import com.example.vamz_sem_praca.screens.Ranajky
import com.example.vamz_sem_praca.screens.UvodnaStrana
import com.example.vamz_sem_praca.screens.Vecera
import com.example.vamz_sem_praca.utvary.MenuPanel

@Composable
fun Navigacia(
    viewModel: FavReceptyViewModel,
    searchViewModel: HladajReceptyViewModel
) {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    MenuPanel(navController = navController, drawerState = drawerState)

    NavHost(navController = navController, startDestination = "uvodnaStrana") {
        composable("uvodnaStrana") { UvodnaStrana().UvodStrana(navController) }
        composable("hlavnaStrana") { HlavnaStrana().HlStrana(navController, searchViewModel) }
        composable("ranajky") { Ranajky().RanajkyStrana(navController, viewModel, searchViewModel) }
        composable("obed") { Obed().ObedStrana(navController, viewModel, searchViewModel) }
        composable("vecera") { Vecera().VeceraStrana(navController, viewModel, searchViewModel) }
        composable("dezert") { Dezert().DezertStrana(navController, viewModel, searchViewModel) }
        composable("prevodGnaH") { PrevodGnaH().PrevodJednotiekGram(navController, searchViewModel) }
        composable("prevodHnaG") { PrevodHnaG().PrevodJednotiekHrncek(navController, searchViewModel) }
        composable("novyRecept") { NovyRecept().VytvorRecepty(navController, searchViewModel) }
        composable("oblubene") { OblubeneRecepty().OblubeneReceptyStrana(navController, viewModel, searchViewModel) }
    }
}
