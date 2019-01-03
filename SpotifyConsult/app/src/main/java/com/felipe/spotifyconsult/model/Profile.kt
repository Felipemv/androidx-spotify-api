package com.felipe.spotifyconsult.model

import com.google.gson.annotations.SerializedName

class Profile {

    @SerializedName("birthdate")
    var birthdate: String = ""

    @SerializedName("country")
    var country: String = ""

    @SerializedName("display_name")
    var displayName: String = ""

    @SerializedName("email")
    var email: String = ""

    @SerializedName("external_urls")
    var externalUrls: ExternalUrl? = null

    @SerializedName("followers")
    var followers: Followers? = null

    @SerializedName("href")
    var href: String? = ""

    @SerializedName("id")
    var id: String? = ""

    @SerializedName("images")
    var images: ArrayList<Image>? = null

    @SerializedName("product")
    var product: String? = ""

    @SerializedName("type")
    var type: String? = ""

    @SerializedName("uri")
    var uri: String? = ""

    override fun toString(): String {
        return "Profile(birthdate='$birthdate', " +
                "country='$country', " +
                "displayName='$displayName', " +
                "email='$email', " +
                "externalUrls=$externalUrls, " +
                "followers=$followers, " +
                "href=$href, " +
                "id=$id, " +
                "images=$images, " +
                "product=$product, " +
                "type=$type, " +
                "uri=$uri)"
    }
}