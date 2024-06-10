package com.example.vamz_sem_praca.data

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf

/**
 * ViewModel trieda pre obľúbené recepty.
 */
class FavReceptyViewModel : ViewModel() {
    /**
     * Zoznam obľúbených receptov.
     */
    var oblubeneRecepty = mutableStateListOf<FavRecepty>()

    /**
     * Prepína obľúbený stav receptu. Ak je recept už v zozname obľúbených, odstráni ho,
     * inak ho pridá do zoznamu obľúbených.
     *
     * @param recepty - recept, ktorého obľúbený stav sa má prepínať
     */
    fun PrepinacOblubene(
        recepty: FavRecepty
    ) {
        if (oblubeneRecepty.contains(recepty)) {
            oblubeneRecepty.remove(recepty)
        } else {
            oblubeneRecepty.add(recepty)
        }
    }

    /**
     * Funkcia skontroluje, či je recept obľúbený.
     *
     * @param recepty - recept, ktorého obľúbený stav sa má skontrolovať
     * @return 'true' ak je recept obľúbený, inak 'false'
     */
    fun isFavorite(recepty: FavRecepty) = oblubeneRecepty.contains(recepty)
}
