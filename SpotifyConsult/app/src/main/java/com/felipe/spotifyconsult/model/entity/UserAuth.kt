package com.felipe.spotifyconsult.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "user_auth")
data class UserAuth(
    @ColumnInfo(name = "token")
    var token: String,

    @ColumnInfo(name = "expires_in")
    var expiresIn: Int

) {

    @PrimaryKey(autoGenerate = true)
    var id: Long = -1

    @ColumnInfo(name = "created_time")
    var date: Long = Date().time

}
