package com.felipe.spotifyconsult.model

import com.google.gson.annotations.SerializedName

class ExternalUrl {

    @SerializedName("key")
    private var key: String = ""
    @SerializedName("value")
    private var value: String = ""

    override fun toString(): String {
        return "ExternalUrl(key='$key', " +
                "value='$value')"
    }


}