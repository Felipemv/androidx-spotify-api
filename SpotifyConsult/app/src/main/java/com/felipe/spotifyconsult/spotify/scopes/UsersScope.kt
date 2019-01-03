package com.felipe.spotifyconsult.spotify.scopes

interface UsersScope {

    companion object {
        const val READ_BIRTHDATE = "user-read-birthdate"
        const val READ_EMAIL = "user-read-email"
        const val READ_PRIVATE = "user-read-private"
    }

}