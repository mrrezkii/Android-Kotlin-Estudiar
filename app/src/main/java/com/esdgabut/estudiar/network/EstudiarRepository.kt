package com.esdgabut.estudiar.network

import com.esdgabut.estudiar.storage.preferences.EstudiarPreferences
import com.esdgabut.estudiar.storage.preferences.PreferencesOnboardingModel
import com.esdgabut.estudiar.storage.preferences.prefFirst

class EstudiarRepository(
    private val pref: EstudiarPreferences
) {
    fun savePreferencesOnboarding(first: Boolean?) {
        pref.put(prefFirst, first!!)
    }

    fun getPreferencesOnboarding(): PreferencesOnboardingModel =
        PreferencesOnboardingModel(pref.getBoolean(prefFirst))
}