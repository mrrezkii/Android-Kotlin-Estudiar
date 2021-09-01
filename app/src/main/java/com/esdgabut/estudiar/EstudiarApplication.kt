package com.esdgabut.estudiar

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.esdgabut.estudiar.data.viewmodel.factory.MainViewModelFactory
import com.esdgabut.estudiar.network.EstudiarRepository
import com.esdgabut.estudiar.storage.preferences.EstudiarPreferences
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import timber.log.Timber

class EstudiarApplication : Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@EstudiarApplication))

        bind() from singleton { EstudiarPreferences(instance()) }
        bind() from singleton { EstudiarRepository(instance()) }

        bind() from provider { MainViewModelFactory(instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Timber.d("Run base application")
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}