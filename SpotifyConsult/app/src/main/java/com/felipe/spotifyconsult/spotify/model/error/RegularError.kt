package com.felipe.spotifyconsult.spotify.model.error

import com.google.gson.annotations.SerializedName

class RegularError {

    @SerializedName("status")
    var status: Int? = null

    @SerializedName("message")
    var message: String = ""
}