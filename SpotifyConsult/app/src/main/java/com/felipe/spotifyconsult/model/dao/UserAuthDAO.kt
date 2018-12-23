package com.felipe.spotifyconsult.model.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.felipe.spotifyconsult.model.entity.UserAuth

@Dao
interface UserAuthDAO {

    @Query("SELECT * from user_auth")
    fun getAll(): List<UserAuth>

    @Insert(onConflict = REPLACE)
    fun insert(userAuth: UserAuth)

    @Query("UPDATE user_auth SET token = :token WHERE id = :id")
    fun update(id:Long, token:String)

    @Query("DELETE FROM user_auth")
    fun deleteAll()

}