package com.yourssu.assignment4

import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences(context: Context) {
    private val prefs: SharedPreferences =
            context.getSharedPreferences("prefs_name", Context.MODE_PRIVATE)

    fun getString(key: String, value: String): String {
        return prefs.getString(key, value).toString()
    }

    fun setString(key: String, str: String) {
        prefs.edit().putString(key, str).apply()
    }
}