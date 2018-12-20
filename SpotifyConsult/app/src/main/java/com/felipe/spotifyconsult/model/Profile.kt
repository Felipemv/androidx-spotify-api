package com.felipe.spotifyconsult.model

import com.google.gson.annotations.SerializedName

class Profile {
    @SerializedName("birthdate")
    private var birthdate: String = ""
    @SerializedName("country")
    private var country: String = ""
    @SerializedName("display_name")
    private var displayName: String = ""
    @SerializedName("string")
    private var email: String = ""
    @SerializedName("external_urls")
    private var externalUrls: ExternalUrl? = null
    @SerializedName("followers")
    private var followers: Followers? = null
    @SerializedName("href")
    private var href: String? = ""
    @SerializedName("id")
    private var id: String? = ""
    @SerializedName("images")
    private var images: ArrayList<UserImage>? = null
    @SerializedName("product")
    private var product: String? = ""
    @SerializedName("type")
    private var type: String? = ""
    @SerializedName("uri")
    private var uri: String? = ""

}