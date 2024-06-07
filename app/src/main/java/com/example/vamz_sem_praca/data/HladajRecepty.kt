package com.example.vamz_sem_praca.data

data class HladajRecepty(
    val id: Int,
    val name: Int
)
class ReceptVyhladavac {
    private val recepty = mutableListOf<HladajRecepty>()

    fun pridajRecept(recept: HladajRecepty) {
        recepty.add(recept)
    }

    fun vyhladajReceptPodlaMena(name: Any?): HladajRecepty? {
        return recepty.find { it.name.equals(name) } //,ignoreCase = true
    }

    fun getVsetkyRecepty(): List<HladajRecepty> {
        return recepty
    }
}
