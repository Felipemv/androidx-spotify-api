package com.felipe.spotifyconsult.model

import com.google.gson.annotations.SerializedName

class Tracks {

    @SerializedName("bars")
    private var bars: ArrayList<TimeInterval>? = null
    @SerializedName("beats")
    private var beats: ArrayList<TimeInterval>? = null
    @SerializedName("sections")
    private var sections: ArrayList<TimeInterval>? = null
    @SerializedName("segments")
    private var segments: ArrayList<TimeInterval>? = null
    @SerializedName("tatums")
    private var tatums: ArrayList<TimeInterval>? = null
}