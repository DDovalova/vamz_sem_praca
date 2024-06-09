package com.example.vamz_sem_praca.navigacia

import androidx.compose.runtime.Composable
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vamz_sem_praca.data.FavReceptyViewModel
import com.example.vamz_sem_praca.screens.Cestoviny
import com.example.vamz_sem_praca.screens.Dezert
import com.example.vamz_sem_praca.screens.HlavnaStrana
import com.example.vamz_sem_praca.screens.Lievance
import com.example.vamz_sem_praca.screens.Milkshake
import com.example.vamz_sem_praca.screens.NovyRecept
import com.example.vamz_sem_praca.screens.Obed
import com.example.vamz_sem_praca.screens.OblubeneRecepty
import com.example.vamz_sem_praca.screens.Polievka
import com.example.vamz_sem_praca.screens.PrevodGnaH
import com.example.vamz_sem_praca.screens.PrevodHnaG
import com.example.vamz_sem_praca.screens.Ranajky
import com.example.vamz_sem_praca.screens.UvodnaStrana
import com.example.vamz_sem_praca.screens.Vecera
import com.example.vamz_sem_praca.utvary.MenuPanel

/**
 * Komponent pre navigáciu v aplikácii.
 *
 * @param viewModel inštancia [FavReceptyViewModel] pre spracovanie obľúbených receptov.
 */
@Composable
fun Navigacia(
    viewModel: FavReceptyViewModel
) {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    // Zobrazuje menu panel s nnavigáciou medzi obrazovkami a stavom panela.
    MenuPanel(
        navController = navController,
        drawerState = drawerState
    )

    // Definuje navigáciu jednotlivých obrazoviek (stránky) v aplikácii.
    NavHost(navController = navController, startDestination = "uvodnaStrana") {
        composable("uvodnaStrana") { UvodnaStrana().UvodStrana(navController) }
        composable("hlavnaStrana") { HlavnaStrana().HlStrana(navController) }
        composable("ranajky") { Ranajky().RanajkyStrana(navController, viewModel) }
        composable("obed") { Obed().ObedStrana(navController, viewModel) }
        composable("vecera") { Vecera().VeceraStrana(navController, viewModel) }
        composable("dezert") { Dezert().DezertStrana(navController, viewModel) }
        composable("prevodGnaH") { PrevodGnaH().PrevodJednotiekGram(navController) }
        composable("prevodHnaG") { PrevodHnaG().PrevodJednotiekHrncek(navController) }
        composable("novyRecept") { NovyRecept().VytvorRecepty(navController) }
        composable("oblubene") { OblubeneRecepty().OblubeneReceptyStrana(navController, viewModel) }
        composable("lievance") { Lievance().LievanceStrana(navController) }
        composable("polievka") { Polievka().PolievkaStrana(navController) }
        composable("cestoviny") { Cestoviny().CestovinyStrana(navController) }
        composable("milkshake") { Milkshake().MilkshakeStrana(navController) }
    }
}
