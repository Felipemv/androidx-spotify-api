package com.felipe.spotifyconsult.api.endpoints

import com.felipe.spotifyconsult.api.EResponseStatus
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

    fun getCurrentProfile(profileListener: ProfileListener, token: String): Profile {
        val service: ProfileService = RetrofitInitializer.createService(ProfileService::class.java, token)
        val call: Call<Profile> = service.getCurrentProfile()

        call.enqueue(object : Callback<Profile> {
            override fun onResponse(call: Call<Profile>, response: Response<Profile>) {
                if(response.body() != null){
                    profileListener.onCurrentProfileLoaded(response.body()!!, EResponseStatus.from(response.code()))
                }else{
                    profileListener.onCurrentProfileFailed()
                }
            }

            override fun onFailure(call: Call<Profile>, t: Throwable) {
                profileListener.onCurrentProfileFailed()
            }
        })

        return Profile()
    }

    fun getProfileById(profileListener: ProfileListener, token: String): Profile {
        val service: ProfileService = RetrofitInitializer.createService(ProfileService::class.java, token)
        val call: Call<Profile> = service.getCurrentProfile()

        call.enqueue(object : Callback<Profile> {
            override fun onResponse(call: Call<Profile>, response: Response<Profile>) {
                profileListener.onProfileLoadedById(response.body()!!, EResponseStatus.from(response.code()))
            }

            override fun onFailure(call: Call<Profile>, t: Throwable) {
                profileListener.onProfileFailedById()
            }
        })

        return Profile()
    }
}