package com.felipe.spotifyconsult.spotify.scopes

interface SpotifyConnectScope {

    companion object {
        const val MODIFY_PLAYBACK_STATE = "user-modify-playback-state"
        const val READ_CURRENTLY_PLAYED = "user-read-currently-playing"
        const val READ_PLAYBACK_STATE = "user-read-playback-state"
    }

}