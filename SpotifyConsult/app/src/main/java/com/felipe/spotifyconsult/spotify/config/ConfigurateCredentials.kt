package com.felipe.spotifyconsult.spotify.config

import android.app.Activity
import com.felipe.spotifyconsult.preferences.PreferencesUtil
import com.felipe.spotifyconsult.spotify.scopes.UsersScope
import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationRequest
import com.spotify.sdk.android.authentication.AuthenticationResponse

class ConfigurateCredentials {

    companion object {
        private const val CLIENT_ID: String = "4d417e8afb9d42be867eb6bfff447726"
        private const val REDIRECT_URI = "http://localhost:8888/callback"

        const val REQUEST_CODE = 1337

        fun authenticateUser(activity: Activity) {
            val builder: AuthenticationRequest.Builder =
                AuthenticationRequest.Builder(CLIENT_ID, AuthenticationResponse.Type.TOKEN, REDIRECT_URI)

            builder.setScopes(arrayOf(UsersScope.READ_BIRTHDATE, UsersScope.READ_EMAIL, UsersScope.READ_PRIVATE))
            val request: AuthenticationRequest = builder.build()

            AuthenticationClient.openLoginActivity(activity, REQUEST_CODE, request)
        }

        fun reAuthenticateUser(){}

        fun verifyCredentials(activity:Activity){
            val preferences: PreferencesUtil = PreferencesUtil.getInstance(activity.applicationContext)

            val token:String? = preferences.token

            if (token == null || token.isEmpty()) {
                authenticateUser(activity)
            } else {
                val expireDate: Long = preferences.createdTime + preferences.expiresIn

                if (expireDate >= System.currentTimeMillis()) {
                    reAuthenticateUser()
                }
            }
        }
    }





}