package com.felipe.spotifyconsult.preferences

import android.content.Context
import android.content.SharedPreferences

class PreferencesUtil {

    companion object {
        private const val FILE_NAME = "com.felipe.spotifyconsult.preferences"

        private const val TOKEN = "token"
        private const val EXPIRES_IN = "expires_in"
        private const val CREATED_TIME = "created_time"

        private lateinit var preferences:SharedPreferences
        private var sInstance: PreferencesUtil? = null

        fun getInstance(context: Context): PreferencesUtil{
            if(sInstance == null){
                preferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
                sInstance = PreferencesUtil()
            }
            return sInstance!!
        }
    }

    var token: String?
        get() = preferences.getString(TOKEN, "")
        set(value) = preferences.edit().putString(TOKEN, value).apply()

    var expiresIn: Int
        get() = preferences.getInt(EXPIRES_IN, 0)
        set(value) = preferences.edit().putInt(EXPIRES_IN, value).apply()

    var createdTime: Long
        get() = preferences.getLong(CREATED_TIME, System.currentTimeMillis())
        set(value) = preferences.edit().putLong(CREATED_TIME, value).apply()
}