package com.felipe.spotifyconsult.model

import com.google.gson.annotations.SerializedName

class Followers {

    @SerializedName("href")
    private var href: String = ""
    @SerializedName("total")
    private var total: Int = 0

    override fun toString(): String {
        return "Followers(href='$href', " +
                "total=$total)"
    }


}