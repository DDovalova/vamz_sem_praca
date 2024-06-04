package com.example.vamz_sem_praca

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vamz_sem_praca.ui.theme.Vamz_sem_pracaTheme
import androidx.compose.ui.Modifier //!

/*
*
*/

class NovyRecept {
    @Composable
    fun VytvorRecepty() {
        var vlozText by remember { mutableStateOf("") }

        Column(
            modifier = androidx.compose.ui.Modifier
                .statusBarsPadding()
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
                .safeDrawingPadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            VrchnyPanel()
            Spacer(modifier = Modifier.height(20.dp))
            VytvorRecept(
                value = vlozText,
                onValueChange = { vlozText = it },
                modifier = androidx.compose.ui.Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth()
            )
            Text(
                text = stringResource(R.string.suroviny),
                modifier = androidx.compose.ui.Modifier
                    .padding(bottom = 16.dp, top = 40.dp)
                    .align(alignment = Alignment.Start)
            )
            VytvorSurovinu(
                value = vlozText,
                onValueChange = { vlozText = it },
                modifier = androidx.compose.ui.Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth()
            )
            Text(
                text = stringResource(R.string.postup),
                modifier = androidx.compose.ui.Modifier
                    .padding(bottom = 16.dp, top = 40.dp)
                    .align(alignment = Alignment.Start)
            )
            VytvorPostup(
                value = vlozText,
                onValueChange = { vlozText = it },
                modifier = androidx.compose.ui.Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth()
            )
            Text(
                text = stringResource(R.string.poznamky),
                modifier = androidx.compose.ui.Modifier
                    .padding(bottom = 16.dp, top = 40.dp)
                    .align(alignment = Alignment.Start)
            )
            VytvorPoznamky(
                value = vlozText,
                onValueChange = { vlozText = it },
                modifier = androidx.compose.ui.Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth()
            )
            VytvorButton()
        }
    }

    @Composable
    fun VytvorRecept(
        value: String,
        onValueChange: (String) -> Unit,
        modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier
    ){
        TextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(stringResource(R.string.nazov_r)) },
            singleLine = false,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = androidx.compose.ui.Modifier.fillMaxWidth()
        )
    }

    @Composable
    fun VrchnyPanel() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
            }
            androidx.compose.material3.Text(
                text = stringResource(R.string.novy_recept),
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
    @Composable
    fun VytvorSurovinu(
        value: String,
        onValueChange: (String) -> Unit,
        modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier
    ){
        TextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(stringResource(R.string.nazov_s)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = androidx.compose.ui.Modifier.fillMaxWidth()
        )
        TextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(stringResource(R.string.mnozstvo_s)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = androidx.compose.ui.Modifier.fillMaxWidth()
        )
    }

    @Composable
    fun VytvorPostup(
        value: String,
        onValueChange: (String) -> Unit,
        modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(stringResource(R.string.napis_postup)) },
            singleLine = false,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = androidx.compose.ui.Modifier.fillMaxWidth()
        )
    }

    @Composable
    fun VytvorPoznamky(
        value: String,
        onValueChange: (String) -> Unit,
        modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(stringResource(R.string.napis_poznamky)) },
            singleLine = false,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = androidx.compose.ui.Modifier.fillMaxWidth()
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
            androidx.compose.material3.Text(stringResource(R.string.vytvorit))
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun NovyReceptPreview() {
        Vamz_sem_pracaTheme {
            VytvorRecepty()
        }
    }
}

