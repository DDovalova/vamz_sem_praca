package com.example.vamz_sem_praca

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
import kotlinx.coroutines.launch
import com.example.vamz_sem_praca.ui.theme.Vamz_sem_pracaTheme
import com.example.vamz_sem_praca.utvary.MenuPanel
import com.example.vamz_sem_praca.utvary.NavigateButton
import com.example.vamz_sem_praca.utvary.ObrazokSTextom
import com.example.vamz_sem_praca.utvary.VrchnyPanel
import com.example.vamz_sem_praca.utvary.PlusButton

class Dezert {
    @Composable
    fun DezertStrana(
        navController: NavHostController
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
                                nazovStrany = stringResource(R.string.dezert),
                                onMenuClick = { scope.launch { drawerState.open() }
                                }
                            )
                            ObrazokParadajkovaPolievka()
                            NavigateButton(
                                navController = navController,
                                destination = "hlavnaStrana",
                                buttonText = stringResource(R.string.paradajkova_polievka)
                            )
                            PlusButton(navController)
                        }
                    }
                )
            }
        )
    }

    @Composable
    fun ObrazokParadajkovaPolievka() {
        ObrazokSTextom(
            imagePainter = painterResource(R.drawable.paradaj_p),
            text = stringResource(R.string.paradajkova_polievka)
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun DezertPreview() {
        Vamz_sem_pracaTheme {
            DezertStrana(rememberNavController())
        }
    }
}