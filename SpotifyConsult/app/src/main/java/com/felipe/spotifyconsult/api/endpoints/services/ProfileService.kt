package com.felipe.spotifyconsult.api.endpoints.services

import com.felipe.spotifyconsult.model.Profile
import retrofit2.Call
import retrofit2.http.GET

interface ProfileService {

    @GET("me")
    fun getCurrentProfile(): Call<Profile>

    @GET("users/{user_id}")
    fun getProfileById(): Call<Profile>
}