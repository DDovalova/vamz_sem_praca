package com.example.vamz_sem_praca

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vamz_sem_praca.ui.theme.Vamz_sem_pracaTheme
import java.text.NumberFormat
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Switch

/*
Podobný návrh z cvičenia 5
 */
class PrevodHnaG {
    @Composable
    fun PrevodJednotiekHrncek() {
        var vlozenaHod by remember { mutableStateOf("") }
        var roundUp by remember { mutableStateOf(false) }

        val amount = vlozenaHod.toDoubleOrNull() ?: 0.0
        val gram = VypocetHnaG(amount, roundUp)

        Column(
            modifier = Modifier
                .statusBarsPadding()
                .padding(horizontal = 40.dp)
                .verticalScroll(rememberScrollState())
                .safeDrawingPadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.prevod_jednotiek),
                modifier = Modifier
                    .padding(bottom = 16.dp, top = 40.dp)
                    .align(alignment = Alignment.Start)
            )
            EditNumberField(
                value = vlozenaHod,
                onValueChange = { vlozenaHod = it },
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth()
            )
            RoundTheTipRow(
                roundUp = roundUp,
                onRoundUpChanged = { roundUp = it },
                modifier = Modifier.padding(bottom = 5.dp) //32
            )
            Text(
                text = stringResource(R.string.vysledok_v_gram, gram),
                style = MaterialTheme.typography.displaySmall
            )
            Spacer(modifier = Modifier.height(150.dp))
        }
    }

    @Composable
    fun EditNumberField(
        value: String,
        onValueChange: (String) -> Unit,
        modifier: Modifier = Modifier
    ){
        TextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(text = stringResource(id = R.string.mnozstvo_v_hrncek)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
    }

    @Composable
    fun RoundTheTipRow(
        roundUp: Boolean,
        onRoundUpChanged: (Boolean) -> Unit,
        modifier: Modifier = Modifier
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .size(48.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = stringResource(R.string.zaokruhlenie))
            Switch(
                modifier = modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End),
                checked = roundUp,
                onCheckedChange = onRoundUpChanged,
            )
        }
    }

    /**
     * Výpočet množstva z hrnčeka na gram na základe vloženej hodnoty používateľa
     */
    private fun VypocetHnaG(amount: Double, roundUp: Boolean): String {
        var gram = amount * 150
        if (roundUp) {
            gram = kotlin.math.ceil(gram)
        }
        return NumberFormat.getNumberInstance().format(gram)
    }

    @Preview(showBackground = true)
    @Composable
    fun PrevodJednotiekGramPreview() {
        Vamz_sem_pracaTheme {
            PrevodJednotiekHrncek()
        }
    }
}