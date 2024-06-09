package com.example.vamz_sem_praca.data

/**
 * Dátová trieda, ktorá reprezentuje obľúbený recept.
 *
 * @property id -jedinečný identifikátor receptu
 * @property nazovR - názov receptu
 * @property obrazokR - identifikátor zdroja pre obrázok receptu
 * @property typ - typ receptu
 */
data class FavRecepty(
    val id: Int,
    val nazovR: String,
    val obrazokR: Int,
    val typ: String
)
