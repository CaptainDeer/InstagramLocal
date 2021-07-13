package com.captaindeer.instagramlocal.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.captaindeer.instagramlocal.data.local.dao.PostDao
import com.captaindeer.instagramlocal.data.local.dao.UserDao
import com.captaindeer.instagramlocal.data.local.entities.PostEntity
import com.captaindeer.instagramlocal.data.local.entities.UserEntity

@Database(entities = [UserEntity::class, PostEntity::class], version = 1, exportSchema = false)
abstract class InstagramDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun postDao(): PostDao

    companion object {
        @Volatile
        private var instance: InstagramDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, InstagramDatabase::class.java, "InstagramLocal.db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }
}