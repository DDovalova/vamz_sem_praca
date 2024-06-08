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
import kotlinx.coroutines.launch
import com.example.vamz_sem_praca.ui.theme.Vamz_sem_pracaTheme
import com.example.vamz_sem_praca.utvary.MenuPanel
import com.example.vamz_sem_praca.utvary.NavigateButton
import com.example.vamz_sem_praca.utvary.ObrazokSTextomASrdcom
import com.example.vamz_sem_praca.utvary.VrchnyPanel
import com.example.vamz_sem_praca.utvary.VytvorButton
import com.example.vamz_sem_praca.utvary.SrdceButton

class Ranajky {
    @Composable
    fun RanajkyStrana(
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
                                nazovStrany = stringResource(R.string.ranajky),
                                onMenuClick = { scope.launch { drawerState.open() } },
                                navController = navController
                            )
                            ObrazokLievance(viewModel, navController)
                            NavigateButton(
                                navController = navController,
                                destination = {"lievance"} ,
                                buttonText = stringResource(R.string.lievance)
                            )
                            VytvorButton(navController)
                        }
                    }
                )
            }
        )
    }

   @Composable
    fun ObrazokLievance(
        viewModel: FavReceptyViewModel,
        navController: NavHostController
    ) {
        val lievance = FavRecepty(
            id = 1,
            nazovR = stringResource(R.string.lievance),
            obrazokR = R.drawable.lievance,
            typ = stringResource(R.string.ranajky)
        )
        ObrazokSTextomASrdcom(
            imagePainter = painterResource(R.drawable.lievance),
            text = stringResource(R.string.lievance),
            favoriteButton = { SrdceButton(viewModel, lievance, navController) },
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun RanajkyPreview() {
        Vamz_sem_pracaTheme {
            RanajkyStrana(
                rememberNavController(),
                FavReceptyViewModel()
            )
        }
    }
}
