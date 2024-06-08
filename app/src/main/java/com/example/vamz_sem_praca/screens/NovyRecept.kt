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
*
*/
class NovyRecept {
    @Composable
    fun VytvorRecepty(
        navController: NavHostController,
        receptViewModel: ReceptViewModel = viewModel()
    ) {
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
                            VrchnyPanel(
                                nazovStrany = stringResource(R.string.novy_recept),
                                onMenuClick = { scope.launch { drawerState.open() } },
                                navController = navController
                            )
                            Spacer(modifier = Modifier.height(0.dp))
                            VytvorRecept(
                                value = receptText,
                                onValueChange = { receptViewModel.receptText  = it },
                                modifier = Modifier
                                    .padding(bottom = 32.dp)
                                    .fillMaxWidth()
                            )
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
                            ViacButton {
                                receptViewModel.surovinyList = receptViewModel.surovinyList + ""
                                receptViewModel.mnozstvaList = receptViewModel.mnozstvaList + ""
                            }
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
                            VytvorPostup(
                                value = postupText,
                                onValueChange = { receptViewModel.postupText = it },
                                modifier = Modifier
                                    .padding(bottom = 32.dp)
                                    .fillMaxWidth()
                            )
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
                            VytvorPoznamky(
                                value = poznamkyText,
                                onValueChange = { receptViewModel.poznamkyText = it },
                                modifier = Modifier
                                    .padding(bottom = 32.dp)
                                    .fillMaxWidth()
                                    .padding(bottom = 5.dp)
                                    .padding(horizontal = 20.dp)
                            )
                            VytvorButton()
                        }
                    }
                )
            }
        )
    }

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
