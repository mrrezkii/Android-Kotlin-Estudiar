package com.esdgabut.estudiar

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import timber.log.Timber

class EstudiarApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Timber.d("Run base application")
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}