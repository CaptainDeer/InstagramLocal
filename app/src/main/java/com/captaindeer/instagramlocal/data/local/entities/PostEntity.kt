package com.captaindeer.instagramlocal.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
class PostEntity(
    @ColumnInfo(name = "image") val img: String,
    @ColumnInfo(name = "description") val description: String
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0
}