package com.example.vamz_sem_praca.screens

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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.vamz_sem_praca.ui.theme.Vamz_sem_pracaTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vamz_sem_praca.R
import com.example.vamz_sem_praca.data.ReceptViewModel
import com.example.vamz_sem_praca.utvary.MenuPanel
import com.example.vamz_sem_praca.utvary.VrchnyPanel
import com.example.vamz_sem_praca.utvary.VytvorTextField
import com.example.vamz_sem_praca.utvary.ViacButton
import kotlinx.coroutines.launch

/**
 * Trieda pre obrazovku NovyRecept.
 */
class NovyRecept {

    /**
     * Funkcia pre zobrazenie obrazovky NovyRecept.
     *
     * @param navController - navigácia medzi obrazovkami v aplikácii
     * @param receptViewModel - viewModel pre recept, poskytuje údaje a logiku pre správu receptov
     */
    @Composable
    fun VytvorRecepty(
        navController: NavHostController,
        receptViewModel: ReceptViewModel = viewModel()
    ) {
        // Získanie údajov z receptViewModel
        val receptText by receptViewModel::receptText
        val surovinyList by receptViewModel::surovinyList
        val mnozstvaList by receptViewModel::mnozstvaList
        val postupText by receptViewModel::postupText
        val poznamkyText by receptViewModel::poznamkyText

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
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Top
                        ) {
                            // Vrchný panel s názvom stránky a tlačidlom menu
                            VrchnyPanel(
                                nazovStrany = stringResource(R.string.novy_recept),
                                onMenuClick = { scope.launch { drawerState.open() } },
                                navController = navController
                            )
                            Spacer(modifier = Modifier.height(0.dp))
                            // Textové pole pre názov receptu
                            VytvorRecept(
                                value = receptText,
                                onValueChange = { receptViewModel.receptText  = it },
                                modifier = Modifier
                                    .padding(bottom = 32.dp)
                                    .fillMaxWidth()
                            )
                            // Nadpis pre suroviny
                            Text(
                                text = stringResource(R.string.suroviny),
                                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(bottom = 16.dp, top = 40.dp)
                                    .align(alignment = Alignment.Start)
                                    .padding(bottom = 5.dp)
                                    .padding(horizontal = 20.dp)
                            )
                            // Textové polia pre suroviny a množstvo
                            surovinyList.forEachIndexed { index, surovina ->
                            VytvorSurovinu(
                                surovinaValue = surovina,
                                onSurovinaChange = { newSurovina ->
                                    receptViewModel.surovinyList = receptViewModel.surovinyList.toMutableList().apply { set(index, newSurovina) }
                                },
                                mnozstvoValue = mnozstvaList.getOrNull(index) ?: "",
                                onMnozstvoChange = { newMnozstvo ->
                                    receptViewModel.mnozstvaList = receptViewModel.mnozstvaList.toMutableList().apply { set(index, newMnozstvo) }
                                },
                                modifier = Modifier
                                    .padding(bottom = 16.dp)
                                    .fillMaxWidth()
                            )
                        }
                            // Tlačidlo na pridanie ďalšej suroviny
                            ViacButton {
                                receptViewModel.surovinyList = receptViewModel.surovinyList + ""
                                receptViewModel.mnozstvaList = receptViewModel.mnozstvaList + ""
                            }
                            // Nadpis pre postup
                            Text(
                                text = stringResource(R.string.postup),
                                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(bottom = 16.dp, top = 40.dp)
                                    .align(alignment = Alignment.Start)
                                    .padding(bottom = 5.dp)
                                    .padding(horizontal = 20.dp)
                                )
                            // Textové pole pre postup
                            VytvorPostup(
                                value = postupText,
                                onValueChange = { receptViewModel.postupText = it },
                                modifier = Modifier
                                    .padding(bottom = 32.dp)
                                    .fillMaxWidth()
                            )
                            // Nadpis pre poznámky
                            Text(
                                text = stringResource(R.string.poznamky),
                                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(bottom = 16.dp, top = 40.dp)
                                    .align(alignment = Alignment.Start)
                                    .padding(bottom = 5.dp)
                                    .padding(horizontal = 20.dp)
                            )
                            // Textové pole pre poznámky
                            VytvorPoznamky(
                                value = poznamkyText,
                                onValueChange = { receptViewModel.poznamkyText = it },
                                modifier = Modifier
                                    .padding(bottom = 32.dp)
                                    .fillMaxWidth()
                                    .padding(bottom = 5.dp)
                                    .padding(horizontal = 20.dp)
                            )
                            // Tlačidlo na vytvorenie receptu
                            VytvorButton()
                        }
                    }
                )
            }
        )
    }

    /**
     * Funkcia pre vytvorenie textového poľa pre názov receptu.
     *
     * @param value - aktuálna hodnota názvu receptu
     * @param onValueChange - funkcia pre aktualizáciu hodnoty názvu receptu
     * @param modifier - modifier pre úpravu vzhľadu textového poľa
     */
    @Composable
    fun VytvorRecept(
        value: String,
        onValueChange: (String) -> Unit,
        modifier: Modifier = Modifier
    ) {
        VytvorTextField(
            value = value,
            onValueChange = onValueChange,
            labelResId = R.string.nazov_r,
            modifier = modifier
                .padding(bottom = 5.dp)
                .padding(horizontal = 20.dp)
        )
    }

    /**
     * Funkcia pre vytvorenie textového poľa pre surovinu a jej množstvo.
     *
     * @param surovinaValue - aktuálna hodnota názvu suroviny
     * @param onSurovinaChange - funkcia pre aktualizáciu hodnoty názvu suroviny
     * @param mnozstvoValue - aktuálna hodnota množstva suroviny
     * @param onMnozstvoChange - funkcia pre aktualizáciu hodnoty množstva suroviny
     * @param modifier - modifier pre úpravu vzhľadu textových polí
     */
    @Composable
    fun VytvorSurovinu(
        surovinaValue: String,
        onSurovinaChange: (String) -> Unit,
        mnozstvoValue: String,
        onMnozstvoChange: (String) -> Unit,
        modifier: Modifier = Modifier
    ){
        TextField(
            value = surovinaValue,
            onValueChange = onSurovinaChange,
            label = { Text(stringResource(R.string.nazov_s)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp)
                .padding(horizontal = 20.dp)
        )
        TextField(
            value = mnozstvoValue,
            onValueChange = onMnozstvoChange,
            label = { Text(stringResource(R.string.mnozstvo_s)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp)
                .padding(horizontal = 20.dp)
        )
    }

    /**
     * Funkcia pre vytvorenie textového poľa pre postup receptu.
     *
     * @param value - aktuálna hodnota postupu receptu
     * @param onValueChange - funkcia pre aktualizáciu hodnoty postupu receptu
     * @param modifier - modifier pre úpravu vzhľadu textového poľa
     */
    @Composable
    fun VytvorPostup(
        value: String,
        onValueChange: (String) -> Unit,
        modifier: Modifier = Modifier
            .padding(bottom = 5.dp)
            .padding(horizontal = 20.dp)
    ) {
        VytvorTextField(
            value = value,
            onValueChange = onValueChange,
            labelResId = R.string.napis_postup,
            modifier = modifier
                .padding(bottom = 5.dp)
                .padding(horizontal = 20.dp)
        )
    }

    /**
     * Funkcia pre vytvorenie textového poľa pre poznámky k receptu.
     *
     * @param value - aktuálna hodnota poznámok k receptu
     * @param onValueChange - funkcia pre aktualizáciu hodnoty poznámok k receptu
     * @param modifier - modifier pre úpravu vzhľadu textového poľa
     */
    @Composable
    fun VytvorPoznamky(
        value: String,
        onValueChange: (String) -> Unit,
        modifier: Modifier = Modifier
    ) {
        VytvorTextField(
            value = value,
            onValueChange = onValueChange,
            labelResId = R.string.napis_poznamky,
            modifier = modifier
        )
    }

    /**
     * Funkcia pre vytvorenie tlačidla na vytvorenie receptu.
     */
    @Composable
    fun VytvorButton() {
        Button(
            onClick = {  },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 30.dp, horizontal = 20.dp)
        ) {
            Text(stringResource(R.string.vytvorit))
        }
    }

    /**
     * Funkcia pre náhľad stránky vytvorenia nového receptu.
     */
    @Preview(showBackground = true)
    @Composable
    fun NovyReceptPreview() {
        Vamz_sem_pracaTheme {
            VytvorRecepty(
                rememberNavController()
            )
        }
    }
}
