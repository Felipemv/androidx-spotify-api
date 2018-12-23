package com.felipe.spotifyconsult.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.felipe.spotifyconsult.model.dao.UserAuthDAO
import com.felipe.spotifyconsult.model.entity.UserAuth

@Database(entities = [UserAuth::class], version = 1)
abstract class SpotifyConsultDb : RoomDatabase() {

    abstract fun userAuthDAO(): UserAuthDAO

    companion object {
        private var sInstance: SpotifyConsultDb? = null

        fun getInstance(context: Context): SpotifyConsultDb {
            if (sInstance == null) {
                synchronized(SpotifyConsultDb::class) {
                    sInstance = Room.databaseBuilder(
                        context.applicationContext,
                        SpotifyConsultDb::class.java,
                        "spotify_consult_database"
                    ).build()
                }
            }
            return sInstance!!
        }

        fun destroyInstance() {
            sInstance = null
        }
    }
}