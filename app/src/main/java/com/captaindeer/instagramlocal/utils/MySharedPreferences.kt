package com.captaindeer.instagramlocal.utils

import android.content.Context
import android.content.SharedPreferences

object MySharedPreferences {
    fun setUserData(context: Context, key: String, value: String) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("PREF_USER", 0)
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getUserData(context: Context, email: String): String {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("PREF_USER", 0)
        return sharedPreferences.getString(email, "").toString()
    }

    fun closeSession(context: Context, session: Boolean) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("PREF_USER", 0)
        sharedPreferences.edit().clear().apply()
    }
}