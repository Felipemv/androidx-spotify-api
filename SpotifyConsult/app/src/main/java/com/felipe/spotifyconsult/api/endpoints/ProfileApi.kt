package com.felipe.spotifyconsult.api.endpoints

import com.felipe.spotifyconsult.api.RetrofitInitializer
import com.felipe.spotifyconsult.api.endpoints.services.ProfileService
import com.felipe.spotifyconsult.listeners.ProfileListener
import com.felipe.spotifyconsult.model.Profile
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileApi {

    companion object {
        val instance: ProfileApi by lazy { ProfileApi() }
    }

    fun getCurrentProfile(profileListener: ProfileListener): Profile {
        val service: ProfileService = RetrofitInitializer.createService(ProfileService::class.java)
        val call: Call<Profile> = service.getCurrentProfile()

        call.enqueue(object : Callback<Profile> {
            override fun onResponse(call: Call<Profile>, response: Response<Profile>) {
                profileListener.onCurrentProfileLoaded(response.body()!!)
            }

            override fun onFailure(call: Call<Profile>, t: Throwable) {
                profileListener.onCurrentProfileFailed()
            }
        })

        return Profile()
    }

    fun getProfileById(): Profile {
        return Profile()
    }
}