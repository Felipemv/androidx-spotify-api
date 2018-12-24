package com.felipe.spotifyconsult

import android.app.Application
import android.content.Intent
import com.facebook.stetho.Stetho
import com.felipe.spotifyconsult.activity.SplashActivity

class SpotifyConsultApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)

        startActivity(Intent(this, SplashActivity::class.java))
    }
}