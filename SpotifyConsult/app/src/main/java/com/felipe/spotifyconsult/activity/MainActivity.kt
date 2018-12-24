package com.felipe.spotifyconsult.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.felipe.spotifyconsult.R
import com.felipe.spotifyconsult.api.EResponseStatus
import com.felipe.spotifyconsult.database.SpotifyConsultDb
import com.felipe.spotifyconsult.listeners.ProfileListener
import com.felipe.spotifyconsult.model.Profile
import com.felipe.spotifyconsult.model.entity.UserAuth
import com.felipe.spotifyconsult.spotify.config.ConfigurateCredentials
import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationResponse

class MainActivity : AppCompatActivity(), ProfileListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ConfigurateCredentials().authenticateUser(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == ConfigurateCredentials.REQUEST_CODE) {
            val response: AuthenticationResponse = AuthenticationClient.getResponse(resultCode, data)

            when (response.type) {
                AuthenticationResponse.Type.TOKEN -> {
                    Toast.makeText(this, "Token: " + response.accessToken, Toast.LENGTH_SHORT).show()

                    Thread {
                        SpotifyConsultDb.getInstance(this).userAuthDAO().insert(UserAuth(response.accessToken))
//                    ProfileApi.instance.getCurrentProfile(this, response.accessToken)
                        Log.i(
                            "profile_endpoint",
                            SpotifyConsultDb.getInstance(this).userAuthDAO().getAll()[0].token
                        )
                    }.start()

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

    override fun onCurrentProfileLoaded(profile: Profile, code: EResponseStatus) {
        Log.i("profile_endpoint", profile.toString())
    }

    override fun onCurrentProfileFailed() {
        Log.i("profile_endpoint", "Could not read profile")
    }

    override fun onProfileLoadedById(profile: Profile, code: EResponseStatus) {
        Log.i("profile_endpoint", profile.toString())
    }

    override fun onProfileFailedById() {
        Log.i("profile_endpoint", "Could not read profile")
    }

}
