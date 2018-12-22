package com.felipe.spotifyconsult.model

import com.google.gson.annotations.SerializedName
import com.spotify.protocol.types.Artist

class Artists {

    @SerializedName("external_urls")
    private var externalUrls: ExternalUrl? = null

    @SerializedName("href")
    private var href: String = ""

    @SerializedName("id")
    private var id: String = ""

    @SerializedName("name")
    private var name: String = ""

    @SerializedName("type")
    private var type: String = ""

    @SerializedName("uri")
    private var uri: String = ""
}