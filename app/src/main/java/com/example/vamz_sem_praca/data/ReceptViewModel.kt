package com.example.vamz_sem_praca.data

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class ReceptViewModel : ViewModel() {
    var receptText by mutableStateOf("")
    var surovinyList by mutableStateOf(listOf(""))
    var mnozstvaList by mutableStateOf(listOf(""))
    var postupText by mutableStateOf("")
    var poznamkyText by mutableStateOf("")
    var hladanyText by mutableStateOf("")
    var zobrazHladajField by mutableStateOf(false)
    var vlozenaHod by mutableStateOf("")
    var roundUp by mutableStateOf(false)
}
