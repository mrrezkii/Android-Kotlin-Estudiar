package com.esdgabut.estudiar.data.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.esdgabut.estudiar.data.viewmodel.MainViewModel
import com.esdgabut.estudiar.network.EstudiarRepository

class MainViewModelFactory(
    private val repository: EstudiarRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}