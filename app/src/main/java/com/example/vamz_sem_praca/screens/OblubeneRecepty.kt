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
import com.example.vamz_sem_praca.data.FavReceptyViewModel
import com.example.vamz_sem_praca.R
import kotlinx.coroutines.launch
import com.example.vamz_sem_praca.ui.theme.Vamz_sem_pracaTheme
import com.example.vamz_sem_praca.utvary.MenuPanel
import com.example.vamz_sem_praca.utvary.NavigateButton
import com.example.vamz_sem_praca.utvary.ObrazokSTextom
import com.example.vamz_sem_praca.utvary.VrchnyPanel
import com.example.vamz_sem_praca.utvary.SrdceButton

class OblubeneRecepty {
    @Composable
    fun OblubeneReceptyStrana(
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
                                nazovStrany = stringResource(R.string.oblubene),
                                onMenuClick = { scope.launch { drawerState.open() }
                                }
                            )
                            viewModel.favoriteRecipes.forEach { recipe ->
                                ObrazokSTextom(
                                    imagePainter = painterResource(recipe.imageResId),
                                    text = recipe.name,
                                    favoriteButton = { SrdceButton(viewModel, recipe) }
                                )
                                NavigateButton(
                                    navController = navController,
                                    destination = "recipeDetail/${recipe.id}",
                                    buttonText = recipe.name
                                )
                            }
                        }
                    }
                )
            }
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun OblubeneReceptyPreview() {
        Vamz_sem_pracaTheme {
            OblubeneReceptyStrana(rememberNavController(), FavReceptyViewModel())
        }
    }
}