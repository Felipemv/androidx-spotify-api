package com.felipe.spotifyconsult.model

import com.google.gson.annotations.SerializedName

class Section {

    @SerializedName("start")
    private var start: Float = 0f
    @SerializedName("duration")
    private var duration: Float = 0f
    @SerializedName("confidence")
    private var confidence: Float = 0f
    @SerializedName("loudness")
    private var loudness: Float = 0f
    @SerializedName("tempo")
    private var tempo: Float = 0f
    @SerializedName("tempo_confidence")
    private var tempoConfidence: Float = 0f
    @SerializedName("key")
    private var key: Int = 0
    @SerializedName("key_confidence")
    private var keyConfidence: Float = 0f
    @SerializedName("mode")
    private var mode: Int = 0
    @SerializedName("mode_confidence")
    private var modeConfidence: Float = 0f
    @SerializedName("time_signature")
    private var timeSignature: Int = 0
    @SerializedName("time_signature_confidence")
    private var timeSignatureConfidence: Float = 0f
}