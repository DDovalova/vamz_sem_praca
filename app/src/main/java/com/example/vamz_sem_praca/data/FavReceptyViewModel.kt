package com.example.vamz_sem_praca.data

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf

class FavReceptyViewModel : ViewModel() {
    var oblubeneRecepty = mutableStateListOf<FavRecepty>()

    fun PrepinacOblubene(
        recepty: FavRecepty
    ) {
        if (oblubeneRecepty.contains(recepty)) {
            oblubeneRecepty.remove(recepty)
        } else {
            oblubeneRecepty.add(recepty)
        }
    }

    fun isFavorite(recepty: FavRecepty) = oblubeneRecepty.contains(recepty)
}
