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
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.vamz_sem_praca.R
import com.example.vamz_sem_praca.data.FavRecepty
import com.example.vamz_sem_praca.ui.theme.Vamz_sem_pracaTheme
import com.example.vamz_sem_praca.utvary.MenuPanel
import com.example.vamz_sem_praca.utvary.ObrazokSTextom
import com.example.vamz_sem_praca.utvary.TextList
import com.example.vamz_sem_praca.utvary.VrchnyPanel
import kotlinx.coroutines.launch

/**
 * Trieda pre obrazovku Milkshake.
 */
class Milkshake {

    /**
     * Funkcia pre zobrazenie obrazovky Milkshake.
     *
     * @param navController - navigácia medzi obrazovkami v aplikácii
     */
    @Composable
    fun MilkshakeStrana(
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
                            horizontalAlignment = Alignment.Start
                        ) {
                            VrchnyPanel(
                                nazovStrany = stringResource(R.string.milkshake),
                                onMenuClick = { scope.launch { drawerState.open() } },
                                navController = navController
                            )
                            ObrazokMilkshake()
                            Text(
                                text = stringResource(R.string.suroviny),
                                fontStyle = FontStyle.Italic,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(bottom = 16.dp, top = 30.dp)
                                    .align(alignment = Alignment.Start)
                                    .padding(bottom = 5.dp)
                                    .padding(horizontal = 20.dp)
                            )
                            TextList(
                                textResourceIds = listOf(
                                    R.string.milkshake_zmrzlina,
                                    R.string.milkshake_mlieko,
                                )
                            )
                            Text(
                                text = stringResource(R.string.postup),
                                fontStyle = FontStyle.Italic,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(bottom = 16.dp, top = 30.dp)
                                    .align(alignment = Alignment.Start)
                                    .padding(bottom = 5.dp)
                                    .padding(horizontal = 20.dp)
                            )
                            Text(
                                text = stringResource(R.string.milkshake_postup),
                                modifier = Modifier
                                    .padding(bottom = 16.dp, top = 0.dp)
                                    .align(alignment = Alignment.Start)
                                    .padding(bottom = 5.dp)
                                    .padding(horizontal = 20.dp)
                            )
                            Text(
                                text = stringResource(R.string.poznamky),
                                fontStyle = FontStyle.Italic,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(bottom = 16.dp, top = 30.dp)
                                    .align(alignment = Alignment.Start)
                                    .padding(bottom = 5.dp)
                                    .padding(horizontal = 20.dp)
                            )
                            Text(
                                text = stringResource(R.string.milkshake_poznamky),
                                modifier = Modifier
                                    .padding(bottom = 16.dp, top = 0.dp)
                                    .align(alignment = Alignment.Start)
                                    .padding(bottom = 5.dp)
                                    .padding(horizontal = 20.dp)
                            )
                        }
                    }
                )
            }
        )
    }

    /**
     * Funkcia pre zobrazenie obrázka Milkshake.
     */
    @Composable
    fun ObrazokMilkshake(
    ) {
        FavRecepty(
            id = 1,
            nazovR = stringResource(R.string.milkshake),
            obrazokR = R.drawable.milkshaked,
            typ = stringResource(R.string.milkshake)
        )
        ObrazokSTextom(
            imagePainter = painterResource(R.drawable.milkshaked),
            text = stringResource(R.string.milkshake)
        )
    }

    /**
     * Funkcia pre náhľad na obrazovku Milkshake.
     */
    @Preview(showBackground = true)
    @Composable
    fun MilkshakePreview() {
        Vamz_sem_pracaTheme {
            MilkshakeStrana(
                rememberNavController(),
            )
        }
    }
}
