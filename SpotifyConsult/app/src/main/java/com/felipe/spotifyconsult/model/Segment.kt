package com.felipe.spotifyconsult.model

import com.google.gson.annotations.SerializedName

class Segment {

    @SerializedName("start")
    private var start: Float = 0f
    @SerializedName("duration")
    private var duration: Float = 0f
    @SerializedName("confidence")
    private var confidence: Float = 0f
    @SerializedName("loudness_start")
    private var loudnessStart: Float = 0f
    @SerializedName("loudness_max")
    private var loudnessMax: Float = 0f
    @SerializedName("loudness_max_time")
    private var loudnessMaxTime: Float = 0f
    @SerializedName("loudness_end")
    private var loudnessEnd: Float = 0f
    @SerializedName("loudness_max")
    private var pitches: Float = 0f
    @SerializedName("loudness_max")
    private var timbre: ArrayList<Float>? = null
}