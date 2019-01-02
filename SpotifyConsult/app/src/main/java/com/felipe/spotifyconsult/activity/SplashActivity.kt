package com.felipe.spotifyconsult.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.felipe.spotifyconsult.R

class SplashActivity : AppCompatActivity(), Runnable {

    var handler: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        handler = Handler()
        handler!!.postDelayed(this, 1000)
    }

    override fun onDestroy() {
        if (handler != null) {
            handler!!.removeCallbacks(this)
        }
        super.onDestroy()
    }

    override fun run() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
