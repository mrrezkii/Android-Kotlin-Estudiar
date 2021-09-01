package com.esdgabut.estudiar.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.esdgabut.estudiar.network.EstudiarRepository
import com.esdgabut.estudiar.storage.preferences.PreferencesOnboardingModel

class MainViewModel(
    val repository: EstudiarRepository
) : ViewModel() {
    val preferencesOnboarding: MutableLiveData<PreferencesOnboardingModel> = MutableLiveData()

    fun getPreferencesOnboarding() {
        preferencesOnboarding.value = repository.getPreferencesOnboarding()
    }

    fun savePreferencesOnboarding(first: Boolean?) {
        repository.savePreferencesOnboarding(first)
    }
}