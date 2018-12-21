package com.felipe.spotifyconsult.model

import com.google.gson.annotations.SerializedName

class Search {

    @SerializedName("q")
    private var q: String = ""
    @SerializedName("type")
    private var type: String = ""
    @SerializedName("market")
    private var market: String? = null
    @SerializedName("limit")
    private var limit: Int? = 20
    @SerializedName("offset")
    private var offset: Int? = 0
    @SerializedName("include_external")
    private var includeExternal: String? = null

}