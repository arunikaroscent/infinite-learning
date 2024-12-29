package com.example.myapplication.model

data class Ghibli(
    val id: Int,
    val name: String,
    val year: String,
    val description: String,
    val photo: Int,
    val background: Int
) {
    fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(
            "$name $year",
        )

        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}