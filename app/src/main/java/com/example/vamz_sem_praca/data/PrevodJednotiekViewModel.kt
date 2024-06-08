package com.example.vamz_sem_praca.data

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
class PrevodJednotiekViewModel : ViewModel() {
    var vlozenaHod by mutableStateOf("")
    var roundUp by mutableStateOf(false)

    fun vypocetHnaG(amount: Double, roundUp: Boolean): String {
        var gram = amount * 150
        if (roundUp) {
            gram = kotlin.math.ceil(gram)
        }
        return java.text.NumberFormat.getNumberInstance().format(gram)
    }
}
