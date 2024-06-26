package com.example.vamz_sem_praca.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.vamz_sem_praca.data.FavRecepty
import com.example.vamz_sem_praca.data.FavReceptyViewModel
import com.example.vamz_sem_praca.R
import com.example.vamz_sem_praca.ui.theme.Vamz_sem_pracaTheme
import com.example.vamz_sem_praca.utvary.MenuPanel
import com.example.vamz_sem_praca.utvary.NavigateButton
import com.example.vamz_sem_praca.utvary.VrchnyPanel
import com.example.vamz_sem_praca.utvary.ObrazokSTextomASrdcom
import com.example.vamz_sem_praca.utvary.VytvorButton
import com.example.vamz_sem_praca.utvary.SrdceButton
import kotlinx.coroutines.launch

/**
 * Trieda predstavujúca obrazovku Obed.
 */
class Obed {

    /**
     * Funkcia pre zobrazenie obrazovky Obed.
     *
     * @param navController - navigácia medzi obrazovkami v aplikácii
     * @param viewModel - viewModel pre prácu s obľúbenými receptami
     */
    @Composable
    fun ObedStrana(
        navController: NavHostController,
        viewModel: FavReceptyViewModel
    ) {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()

        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                MenuPanel(
                    navController = navController,
                    drawerState = drawerState
                )
            },
            content = {
                Scaffold(
                    content = { padding ->
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .statusBarsPadding()
                                .verticalScroll(rememberScrollState())
                                .safeDrawingPadding()
                                .padding(horizontal = 0.dp),
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            VrchnyPanel(
                                nazovStrany = stringResource(R.string.obed),
                                onMenuClick = { scope.launch { drawerState.open() } },
                                navController = navController
                            )
                            ObrazokParadajkovaPolievka(viewModel, navController)
                            NavigateButton(
                                navController = navController,
                                destination = {"polievka"},
                                buttonText = stringResource(R.string.paradajkova_polievka)
                            )
                            VytvorButton(navController)
                        }
                    }
                )
            }
        )
    }

    /**
     * Funkcia pre zobrazenie obrázka s textom a srdcom pre polievku.
     *
     * @param viewModel - viewModel pre prácu s obľúbenými receptami
     * @param navController - navigácia medzi obrazovkami
     */
    @Composable
    fun ObrazokParadajkovaPolievka(
        viewModel: FavReceptyViewModel,
        navController: NavHostController
    ) {
        val polievka = FavRecepty(
            id = 1,
            nazovR = stringResource(R.string.paradajkova_polievka),
            obrazokR = R.drawable.paradaj_p,
            typ = stringResource(R.string.obed)
        )
        ObrazokSTextomASrdcom(
            imagePainter = painterResource(R.drawable.paradaj_p),
            text = stringResource(R.string.paradajkova_polievka),
            favoriteButton = { SrdceButton(viewModel, polievka, navController) }
        )
    }

    /**
     * Funkcia pre náhľad na obrazovky obed.
     */
    @Preview(showBackground = true)
    @Composable
    fun ObedPreview() {
        Vamz_sem_pracaTheme {
            ObedStrana(
                rememberNavController(),
                FavReceptyViewModel()
            )
        }
    }
}
