package jaesung.project.wanted_preonboarding_android.ui

import android.app.Application
import timber.log.Timber

class WantedApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        setUpTimber()
    }

    private fun setUpTimber() {
        Timber.plant(Timber.DebugTree())
    }
}