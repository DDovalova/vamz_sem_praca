package com.example.vamz_sem_praca.data

import androidx.lifecycle.ViewModel
import com.example.vamz_sem_praca.R

class HladajReceptyViewModel : ViewModel() {
    private val recipeSearch = ReceptVyhladavac()

    init {
        recipeSearch.pridajRecept(HladajRecepty(id = 1, name = R.string.milkshake))
        recipeSearch.pridajRecept(HladajRecepty(id = 2, name = R.string.lievance))
        recipeSearch.pridajRecept(HladajRecepty(id = 3, name = R.string.paradajkova_polievka))
        recipeSearch.pridajRecept(HladajRecepty(id = 4, name = R.string.cestoviny))
    }

    fun pridajRecept(recept: HladajRecepty) {
        recipeSearch.pridajRecept(recept)
    }

    fun vyhladajReceptPodlaMena(name: Any?): HladajRecepty? {
        return recipeSearch.vyhladajReceptPodlaMena(name)
    }

    fun getVsetkyRecepty(): List<HladajRecepty> {
        return recipeSearch.getVsetkyRecepty()
    }
}