package com.felipe.spotifyconsult.spotify.config

import android.app.Activity
import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationRequest
import com.spotify.sdk.android.authentication.AuthenticationResponse

class ConfigurateCredentials {

    private val CLIENT_ID: String = "4d417e8afb9d42be867eb6bfff447726"
    private val REDIRECT_URI = "http://localhost:8888/callback"

    companion object {
        val REQUEST_CODE = 1337
    }

    fun authenticateUser(activity: Activity) {
        var builder: AuthenticationRequest.Builder =
            AuthenticationRequest.Builder(CLIENT_ID, AuthenticationResponse.Type.TOKEN, REDIRECT_URI)

        builder.setScopes(Array(1) { "streaming" })
        var request: AuthenticationRequest = builder.build()

        AuthenticationClient.openLoginActivity(activity, REQUEST_CODE, request)
    }

}