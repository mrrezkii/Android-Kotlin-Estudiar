package com.esdgabut.estudiar.data.model

data class TentorModel(
    val id: Long = counter++,
    val name: String,
    val url: String,
    val city: String
) {
    companion object {
        private var counter = 0L
    }
}