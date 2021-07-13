package com.captaindeer.instagramlocal.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.captaindeer.instagramlocal.data.local.entities.PostEntity

@Dao
interface PostDao {

    @Insert
    fun insert(postEntity: PostEntity)

    @Update
    fun update(postEntity: PostEntity)

    @Delete
    fun delete(postEntity: PostEntity)

}