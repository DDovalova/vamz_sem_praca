package com.example.vamz_sem_praca.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.vamz_sem_praca.R
import com.example.vamz_sem_praca.data.HladajReceptyViewModel
import kotlinx.coroutines.launch
import com.example.vamz_sem_praca.ui.theme.Vamz_sem_pracaTheme
import com.example.vamz_sem_praca.utvary.MenuPanel
import com.example.vamz_sem_praca.utvary.ObrazokSButtonom
import com.example.vamz_sem_praca.utvary.VrchnyPanel

class HlavnaStrana {
    @Composable
    fun HlStrana(
        navController: NavHostController,
        searchViewModel: HladajReceptyViewModel
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
                                nazovStrany = stringResource(R.string.app_name),
                                onMenuClick = { scope.launch { drawerState.open() } }
                            ) { searchQuery ->
                                val foundRecipe = searchViewModel.vyhladajReceptPodlaMena(searchQuery)
                                if (foundRecipe != null) {
                                    navController.navigate("recept/${foundRecipe.id}")
                                }
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            ObrazokRanajky(navController)
                            Spacer(modifier = Modifier.height(10.dp))
                            ObrazokObed(navController)
                            Spacer(modifier = Modifier.height(10.dp))
                            ObrazokVecera(navController)
                            Spacer(modifier = Modifier.height(10.dp))
                            ObrazokDezert(navController)
                        }
                    }
                )
            }
        )
    }

    @Composable
    fun ObrazokRanajky(navController: NavHostController) {
        ObrazokSButtonom(
            navController = navController,
            imageRes = R.drawable.ranajky,
            buttonText = stringResource(R.string.ranajky),
            navigateTo = "ranajky"
        )
    }

    @Composable
    fun ObrazokObed(navController: NavHostController) {
        ObrazokSButtonom(
            navController = navController,
            imageRes = R.drawable.obed,
            buttonText = stringResource(R.string.obed),
            navigateTo = "obed"
        )
    }

    @Composable
    fun ObrazokVecera(navController: NavHostController) {
        ObrazokSButtonom(
            navController = navController,
            imageRes = R.drawable.vecera,
            buttonText = stringResource(R.string.vecera),
            navigateTo = "vecera"
        )
    }

    @Composable
    fun ObrazokDezert(navController: NavHostController) {
        ObrazokSButtonom(
            navController = navController,
            imageRes = R.drawable.dezert,
            buttonText = stringResource(R.string.dezert),
            navigateTo = "dezert"
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun HlavnaStranaPreview() {
        Vamz_sem_pracaTheme {
            HlStrana(
                rememberNavController(),
                HladajReceptyViewModel()
            )
        }
    }
}

