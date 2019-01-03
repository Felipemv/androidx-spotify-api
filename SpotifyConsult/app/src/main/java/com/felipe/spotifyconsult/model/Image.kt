package com.felipe.spotifyconsult.model

import com.google.gson.annotations.SerializedName

class Image {

    @SerializedName("height")
    var height: Int? = null

    @SerializedName("url")
    var url: String = ""

    @SerializedName("width")
    var width: Int? = null

    override fun toString(): String {
        return "Image(height=$height, " +
                "url='$url', " +
                "width=$width)"
    }


}