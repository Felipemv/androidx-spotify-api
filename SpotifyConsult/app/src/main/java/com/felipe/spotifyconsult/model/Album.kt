package com.felipe.spotifyconsult.model

import com.google.gson.annotations.SerializedName

class Album {

    @SerializedName("album_type")
    private var albumType: String = ""

    @SerializedName("artists")
    private var artists: ArrayList<Artists>? = null

    @SerializedName("available_markets")
    private var availableMarkets: ArrayList<String>? = null

    @SerializedName("copyrights")
    private var copyrights: ArrayList<Copyright>? = null

    @SerializedName("external_ids")
    private var externalIds: ExternalId? = null

    @SerializedName("external_urls")
    private var externalUrls: ExternalUrl? = null

    @SerializedName("genres")
    private var genres: ArrayList<String>? = null

    @SerializedName("href")
    private var href: String = ""

    @SerializedName("id")
    private var id: String = ""

    @SerializedName("images")
    private var images: ArrayList<Image>? = null

    @SerializedName("label")
    private var label: String = ""

    @SerializedName("name")
    private var name: String = ""

    @SerializedName("popularity")
    private var popularity: Int? = 0

    @SerializedName("release_date")
    private var releaseDate: String = ""

    @SerializedName("release_date_precision")
    private var releaseDatePrecision: String = ""

    @SerializedName("restrictions")
    private var restrictions: String? = null

    @SerializedName("tracks")
    private var tracks: ArrayList<Tracks>? = null

    @SerializedName("type")
    private var type: String = ""

    @SerializedName("uri")
    private var uri: String = ""
}