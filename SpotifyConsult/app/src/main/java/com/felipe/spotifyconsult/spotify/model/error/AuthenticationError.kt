package com.felipe.spotifyconsult.spotify.model.error

import com.google.gson.annotations.SerializedName

class AuthenticationError {

    @SerializedName("error")
    var error: String = ""

    @SerializedName("error_description")
    var description: String = ""
}