package com.felipe.spotifyconsult.listeners

import com.felipe.spotifyconsult.api.EResponseStatus
import com.felipe.spotifyconsult.model.Profile

interface ProfileListener {

    fun onCurrentProfileLoaded(profile: Profile, code: EResponseStatus)

    fun onCurrentProfileFailed()

    fun onProfileLoadedById(profile: Profile, code: EResponseStatus)

    fun onProfileFailedById()
}