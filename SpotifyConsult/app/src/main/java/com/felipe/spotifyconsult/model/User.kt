package com.felipe.spotifyconsult.model

import com.google.gson.annotations.SerializedName

class User {

    @SerializedName("display_name")
    private var display_name: String = ""

    @SerializedName("external_urls")
    private var external_urls: ExternalUrl? = null

    @SerializedName("followers")
    private var followers: Followers? = null

    @SerializedName("href")
    private var href: String = ""

    @SerializedName("id")
    private var id: String = ""

    @SerializedName("images")
    private var images: Array<Image>? = null

    @SerializedName("type")
    private var type: String = ""

    @SerializedName("uri")
    private var uri: String = ""
}