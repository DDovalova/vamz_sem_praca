package com.example.vamz_sem_praca

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.vamz_sem_praca.utvary.MenuPanel
import com.example.vamz_sem_praca.utvary.ObrazokSButtonom
import com.example.vamz_sem_praca.utvary.VrchnyPanel
import kotlinx.coroutines.launch

class HlavnaStrana {
    @Composable
    fun HlStrana(
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
                                nazovStrany = stringResource(R.string.app_name),
                                onMenuClick = { scope.launch { drawerState.open() }
                                }
                            )
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
            HlStrana(rememberNavController(), )
        }
    }
}

