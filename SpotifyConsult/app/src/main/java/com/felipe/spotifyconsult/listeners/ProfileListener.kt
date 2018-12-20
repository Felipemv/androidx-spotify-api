package com.felipe.spotifyconsult.listeners

import com.felipe.spotifyconsult.model.Profile

interface ProfileListener {

    fun onCurrentProfileLoaded(profile: Profile)

    fun onCurrentProfileFailed()
}