package com.felipe.spotifyconsult.spotify.scopes

interface PlaylistsScope {

    companion object {
        const val READ_PRIVATE = "playlist-read-private"
        const val MODIFY_PRIVATE = "playlist-modify-private"
        const val MODIFY_PUBLIC = "playlist-modify-public"
        const val READ_COLLABORATIVE = "playlist-read-collaborative"
    }
}