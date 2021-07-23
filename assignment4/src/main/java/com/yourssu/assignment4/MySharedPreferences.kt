package com.yourssu.assignment4

import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences(context: Context) {

    private val prefsFilename = "prefs"
    private val prefsKeyName = "nameKey"
    private val prefs: SharedPreferences = context.getSharedPreferences(prefsFilename, 0)

    var nameKey: String?
        get() = prefs.getString(prefsKeyName, "")
        set(value) = prefs.edit().putString(prefsKeyName, value).apply()
}