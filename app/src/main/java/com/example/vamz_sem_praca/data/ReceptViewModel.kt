package com.example.vamz_sem_praca.data

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

/**
 * ViewModel trieda pre zachovanie stavu textu (String).
 */
class ReceptViewModel : ViewModel() {
    /**
     * Text pre názov receptu.
     */
    var receptText by mutableStateOf("")

    /**
     * Zoznam surovín.
     */
    var surovinyList by mutableStateOf(listOf(""))

    /**
     * Zoznam množstiev jednotlivých surovín.
     */
    var mnozstvaList by mutableStateOf(listOf(""))

    /**
     * Text postupu prípravy receptu.
     */
    var postupText by mutableStateOf("")

    /**
     * Text poznámky k receptu.
     */
    var poznamkyText by mutableStateOf("")

    /**
     * Text hľadaného názvu receptu.
     */
    var hladanyText by mutableStateOf("")

    /**
     * Premenná určuje, či sa má zobraziť pole na vyhľadávanie.
     */
    var zobrazHladajField by mutableStateOf(false)

    /**
     * Hodnota vložená užívateľom na prevod jednotiek.
     */
    var vlozenaHod by mutableStateOf("")

    /**
     * Premenná určuje, či sa má zaokrúhliť číslo.
     */
    var roundUp by mutableStateOf(false)
}
