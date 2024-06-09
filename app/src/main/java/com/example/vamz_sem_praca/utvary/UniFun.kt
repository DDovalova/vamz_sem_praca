package com.example.vamz_sem_praca.utvary

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.vamz_sem_praca.R

/**
 * Komponent pre úpravu číselnej hodnoty.
 *
 * @param value - aktuálna hodnota textového poľa
 * @param onValueChange - funkcia volaná pri zmene hodnoty
 * @param labelText - text popisujúci textové pole
 * @param modifier - modifikátor pre prispôsobenie vzhľadu komponentu
 */
@Composable
fun UpravaCisla(
    value: String,
    onValueChange: (String) -> Unit,
    labelText: String,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = labelText) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = modifier.fillMaxWidth()
    )
}

/**
 * Komponent pre prepínač zaokrúhľovania čísla.
 *
 * @param roundUp - boolean hodnota označujúca, či sa má číslo zaokrúhliť
 * @param onRoundUpChanged - funkcia volaná pri zmene stavu prepínača
 * @param modifier - modifikátor pre prispôsobenie vzhľadu komponentu
 */
@Composable
fun ZaokruhliCislo(
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
 * Komponent pre vytvorenie textového poľa.
 *
 * @param value - aktuálna hodnota textového poľa
 * @param onValueChange - funkcia volaná pri zmene hodnoty
 * @param labelResId - id reťazca zdroja pre popis textového poľa
 * @param modifier - modifikátor pre prispôsobenie vzhľadu komponentu
 */
@Composable
fun VytvorTextField(
    value: String,
    onValueChange: (String) -> Unit,
    labelResId: Int,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = stringResource(id = labelResId)) },
        singleLine = false,
        keyboardOptions = KeyboardOptions(keyboardType = androidx.compose.ui.text.input.KeyboardType.Text),
        modifier = modifier.fillMaxWidth()
    )
}

/**
 * Komponent pre zobrazenie zoznamu textov.
 *
 * @param textResourceIds - Zoznam id reťazcov zdrojov pre zobrazenie textov
 */
@Composable
fun TextList(textResourceIds: List<Int>) {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
    ) {
        textResourceIds.forEach { textResId ->
            Text(
                text = stringResource(id = textResId),
                modifier = Modifier
                    .padding(vertical = 4.dp)
            )
        }
    }
}
