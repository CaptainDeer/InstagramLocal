package com.captaindeer.instagramlocal.data.local.dao

import androidx.room.*
import com.captaindeer.instagramlocal.data.local.entities.UserEntity

@Dao
interface UserDao {

    @Insert
    fun insert(userEntity: UserEntity)

    @Update
    fun update(userEntity: UserEntity)

    @Delete
    fun delete(userEntity: UserEntity)

    @Query("select * from users where email like :email and password like :password")
    fun validUser(email:String, password: String): UserEntity

}