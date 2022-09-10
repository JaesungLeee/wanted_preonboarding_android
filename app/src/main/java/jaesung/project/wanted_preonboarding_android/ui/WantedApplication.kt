package jaesung.project.wanted_preonboarding_android.ui

import android.app.Application
import android.content.Context
import jaesung.project.wanted_preonboarding_android.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class WantedApplication : Application() {

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@WantedApplication)
            modules(dataSourceModule, dbModule, networkModule, repositoryModule, viewModelModule, useCaseModule)
        }

        setUpTimber()
    }

    private fun setUpTimber() {
        Timber.plant(Timber.DebugTree())
    }

    companion object {
        lateinit var instance: WantedApplication
        fun getAppContext(): Context {
            return instance.applicationContext
        }
    }
}