package com.felipe.spotifyconsult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.felipe.spotifyconsult.api.endpoints.ProfileApi
import com.felipe.spotifyconsult.listeners.ProfileListener
import com.felipe.spotifyconsult.model.Profile
import com.felipe.spotifyconsult.spotify.config.ConfigurateCredentials
import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationResponse

class MainActivity : AppCompatActivity(), ProfileListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var credentials: ConfigurateCredentials = ConfigurateCredentials()
        credentials.authenticateUser(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == ConfigurateCredentials.REQUEST_CODE) {
            val response: AuthenticationResponse = AuthenticationClient.getResponse(resultCode, data)

            when (response.type) {
                AuthenticationResponse.Type.TOKEN -> {
                    Toast.makeText(this, "Token: " + response.accessToken, Toast.LENGTH_SHORT).show()

                    ProfileApi.instance.getCurrentProfile(this, response.accessToken)
                    Log.i("profile_endpoint", response.accessToken)
                }

                AuthenticationResponse.Type.ERROR -> {
                    Toast.makeText(this, "Error: " + response.error, Toast.LENGTH_SHORT).show()
                }

                else -> {
                    Toast.makeText(this, "Else", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onCurrentProfileLoaded(profile: Profile) {
        Log.i("profile_endpoint", profile.toString())
    }

    override fun onCurrentProfileFailed() {
        Log.i("profile_endpoint", "Could not read profile")
    }
}
