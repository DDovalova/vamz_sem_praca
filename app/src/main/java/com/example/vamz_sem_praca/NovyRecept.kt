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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.vamz_sem_praca.ui.theme.Vamz_sem_pracaTheme
import androidx.compose.ui.Modifier //!
import com.example.vamz_sem_praca.utvary.MenuPanel
import com.example.vamz_sem_praca.utvary.VrchnyPanel
import com.example.vamz_sem_praca.utvary.VytvorTextField
import kotlinx.coroutines.launch

/*
*
*/
class NovyRecept {
    @Composable
    fun VytvorRecepty(
        navController: NavHostController
    ) {
        var receptText by remember { mutableStateOf("") }
        var surovinyList by remember { mutableStateOf(listOf("")) }
        var mnozstvaList by remember { mutableStateOf(listOf("")) }
        var postupText by remember { mutableStateOf("") }
        var poznamkyText by remember { mutableStateOf("") }

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
                            onMenuClick = { scope.launch { drawerState.open() }
                            }
                        )
                            Spacer(modifier = Modifier.height(0.dp))
                            VytvorRecept(
                                value = receptText,
                                onValueChange = { receptText = it },
                                modifier = Modifier
                                    .padding(bottom = 32.dp)
                                    .fillMaxWidth()
                        )
                            Text(
                                text = stringResource(R.string.suroviny),
                                modifier = Modifier
                                    .padding(bottom = 16.dp, top = 40.dp)
                                    .align(alignment = Alignment.Start)
                        )
                            surovinyList.forEachIndexed { index, surovina ->
                            VytvorSurovinu(
                                surovinaValue = surovina,
                                onSurovinaChange = { newSurovina ->
                                    surovinyList = surovinyList.toMutableList().apply { set(index, newSurovina) }
                                },
                                mnozstvoValue = mnozstvaList.getOrNull(index) ?: "",
                                onMnozstvoChange = { newMnozstvo ->
                                    mnozstvaList = mnozstvaList.toMutableList().apply { set(index, newMnozstvo) }
                                },
                                modifier = Modifier
                                    .padding(bottom = 16.dp)
                                    .fillMaxWidth()
                            )
                        }
                            ViacButton {
                                surovinyList = surovinyList + ""
                                mnozstvaList = mnozstvaList + ""
                            }
                            Text(
                                text = stringResource(R.string.postup),
                                modifier = Modifier
                                    .padding(bottom = 16.dp, top = 40.dp)
                                    .align(alignment = Alignment.Start)
                                )
                            VytvorPostup(
                                value = postupText,
                                onValueChange = { postupText = it },
                                modifier = Modifier
                                    .padding(bottom = 32.dp)
                                    .fillMaxWidth()
                            )
                            Text(
                                text = stringResource(R.string.poznamky),
                                modifier = Modifier
                                    .padding(bottom = 16.dp, top = 40.dp)
                                    .align(alignment = Alignment.Start)
                            )
                            VytvorPoznamky(
                                value = poznamkyText,
                                onValueChange = { poznamkyText = it },
                                modifier = Modifier
                                    .padding(bottom = 32.dp)
                                    .fillMaxWidth()
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
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = mnozstvoValue,
            onValueChange = onMnozstvoChange,
            label = { Text(stringResource(R.string.mnozstvo_s)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
    }

    @Composable
    fun VytvorPostup(
        value: String,
        onValueChange: (String) -> Unit,
        modifier: Modifier = Modifier
    ) {
        VytvorTextField(
            value = value,
            onValueChange = onValueChange,
            labelResId = R.string.napis_postup,
            modifier = modifier
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
                .padding(vertical = 60.dp)
        ) {
            Text(stringResource(R.string.vytvorit))
        }
    }

    @Composable
    fun ViacButton(onClick: () -> Unit) {
        FloatingActionButton(
            onClick = onClick,
            modifier = Modifier
                .padding(16.dp)
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Add")
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun NovyReceptPreview() {
        Vamz_sem_pracaTheme {
            VytvorRecepty(rememberNavController())
        }
    }
}

