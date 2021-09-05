package com.esdgabut.estudiar.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TentorModel(
    val id: Long = counter++,
    val name: String,
    val url: String,
    val latar_belakang: String
) : Parcelable {
    companion object {
        private var counter = 0L
    }
}