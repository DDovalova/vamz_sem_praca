package com.example.vamz_sem_praca.data

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import com.example.vamz_sem_praca.data.FavRecepty

class FavReceptyViewModel : ViewModel() {
    var favoriteRecipes = mutableStateListOf<FavRecepty>()

    fun PrepinacOblubene(recepty: FavRecepty) {
        if (favoriteRecipes.contains(recepty)) {
            favoriteRecipes.remove(recepty)
        } else {
            favoriteRecipes.add(recepty)
        }
    }

    fun isFavorite(recepty: FavRecepty) = favoriteRecipes.contains(recepty)
}