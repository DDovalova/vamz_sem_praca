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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vamz_sem_praca.ui.theme.Vamz_sem_pracaTheme
import java.text.NumberFormat
import com.example.vamz_sem_praca.utvary.VrchnyPanel
import com.example.vamz_sem_praca.utvary.UpravaCisla
import com.example.vamz_sem_praca.utvary.ZaokruhliCislo

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
            verticalArrangement = Arrangement.Top
        ) {
            //VrchnyPanel(nazovStrany = stringResource(R.string.prevod_jednotiek))
            Spacer(modifier = Modifier.height(100.dp))
            UpravaCisla(
                value = vlozenaHod,
                onValueChange = { vlozenaHod = it },
                labelText = stringResource(R.string.mnozstvo_v_hrncek),
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth()
            )
            ZaokruhliCislo(
                roundUp = roundUp,
                onRoundUpChanged = { roundUp = it },
                modifier = Modifier.padding(bottom = 5.dp)
            )
            Text(
                text = stringResource(R.string.vysledok_v_gram, gram),
                style = MaterialTheme.typography.displaySmall
            )
            Spacer(modifier = Modifier.height(150.dp))
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