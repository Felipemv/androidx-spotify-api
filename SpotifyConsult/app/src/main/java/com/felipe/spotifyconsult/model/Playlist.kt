package com.felipe.spotifyconsult.model

import com.google.gson.annotations.SerializedName

class Playlist {
    @SerializedName("collaborative")
    private var collaborative: Boolean = false

    @SerializedName("external_urls")
    private var externalUrl: ExternalUrl? = null

    @SerializedName("href")
    private var href: String = ""

    @SerializedName("id")
    private var id: String = ""

    @SerializedName("images")
    private var images: ArrayList<Image>? = null

    @SerializedName("name")
    private var name: String = ""

    @SerializedName("owner")
    private var owner: User? = null

    @SerializedName("public")
    private var public: Boolean? = false

    @SerializedName("snapshot_id")
    private var snapshot_id: String = ""

    @SerializedName("tracks")
    private var tracks: Tracks? = null

    @SerializedName("type")
    private var type: String = ""

    @SerializedName("uri")
    private var uri: String = ""
}