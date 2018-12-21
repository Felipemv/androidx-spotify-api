package com.felipe.spotifyconsult.model

import com.google.gson.annotations.SerializedName

class TimeInterval {

    @SerializedName("start")
    private var start: Float = 0f
    @SerializedName("duration")
    private var duration: Float = 0f
    @SerializedName("confidence")
    private var confidence: Float = 0f
}