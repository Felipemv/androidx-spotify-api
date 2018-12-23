package com.felipe.spotifyconsult.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_auth")
data class UserAuth(
    @ColumnInfo(name = "token")
    var token: String

) {

    @PrimaryKey(autoGenerate = true)
    var id: Long = -1

}
