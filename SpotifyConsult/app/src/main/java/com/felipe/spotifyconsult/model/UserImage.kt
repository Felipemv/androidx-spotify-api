package com.felipe.spotifyconsult.model

import com.google.gson.annotations.SerializedName

class UserImage {

    @SerializedName("height")
    private var height: Int? = null
    @SerializedName("url")
    private var url: String = ""
    @SerializedName("width")
    private var width: Int? = null
}