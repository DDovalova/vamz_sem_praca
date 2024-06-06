package com.example.vamz_sem_praca

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.vamz_sem_praca.ui.theme.Vamz_sem_pracaTheme
import com.example.vamz_sem_praca.utvary.MenuPanel
import java.text.NumberFormat
import com.example.vamz_sem_praca.utvary.VrchnyPanel
import com.example.vamz_sem_praca.utvary.UpravaCisla
import com.example.vamz_sem_praca.utvary.ZaokruhliCislo
import kotlinx.coroutines.launch
import kotlin.math.ceil

/*
Podobný návrh z cvičenia 5
 */
class PrevodGnaH {
    @Composable
    fun PrevodJednotiekGram(
        navController: NavHostController
    ) {
        var vlozenaHod by remember { mutableStateOf("") }
        var roundUp by remember { mutableStateOf(false) }

        val amount = vlozenaHod.toDoubleOrNull() ?: 0.0
        val hrncek = VypocetGnaH(amount, roundUp)

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
                                .fillMaxWidth()
                                .statusBarsPadding()
                                .verticalScroll(rememberScrollState())
                                .safeDrawingPadding()
                                .padding(horizontal = 0.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Top
                        ) {
                            VrchnyPanel(
                                nazovStrany = stringResource(R.string.prevod_jednotiek),
                                onMenuClick = {
                                    scope.launch { drawerState.open() }
                                }
                            )
                            Spacer(modifier = Modifier.height(100.dp))
                            UpravaCisla(
                                value = vlozenaHod,
                                onValueChange = { vlozenaHod = it },
                                labelText = stringResource(R.string.mnozstvo_v_gram),
                                modifier = Modifier
                                    .padding(bottom = 32.dp)
                                    .padding(horizontal = 20.dp)
                                    .fillMaxWidth()
                            )
                            ZaokruhliCislo(
                                roundUp = roundUp,
                                onRoundUpChanged = { roundUp = it },
                                modifier = Modifier
                                    .padding(bottom = 5.dp)
                                    .padding(horizontal = 20.dp)
                            )
                            Text(
                                text = stringResource(R.string.vysledok_v_hrncek, hrncek),
                                style = MaterialTheme.typography.displaySmall,
                                modifier = Modifier
                                    .padding(bottom = 5.dp)
                                    .padding(horizontal = 20.dp)
                            )
                            Spacer(modifier = Modifier.height(150.dp))
                        }
                    }
                )
            }
        )
    }

    /**
     * Výpočet množstva z gramoch na hrnčeky na základe vloženej hodnoty používateľa
     */
    private fun VypocetGnaH(amount: Double, roundUp: Boolean): String {
        var hrncek = amount / 150
        if (roundUp) {
            hrncek = ceil(hrncek)
        }
        return NumberFormat.getNumberInstance().format(hrncek)
    }

    @Preview(showBackground = true)
    @Composable
    fun PrevodJednotiekGramPreview() {
        Vamz_sem_pracaTheme {
            PrevodJednotiekGram(rememberNavController())
        }
    }
}