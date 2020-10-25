package com.app.sociollademo.utils

import android.content.Context
import android.content.SharedPreferences


public class SessionManger(context: Context, prefFileName: String) {

    private val mPrefs: SharedPreferences
    private var editor: SharedPreferences.Editor? = null

    init {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)
        editor = mPrefs.edit()
    }
    fun setUserID(user_id: Int) {
        mPrefs.edit().putInt(POSITION, user_id).apply()

    }

    fun getUserID(): Int {
        return mPrefs.getInt(POSITION, 0)
    }
    fun clearSessionManger() {
        editor!!.clear()
        editor!!.commit()

    }
    fun clearAll() {
        mPrefs.edit().clear().commit()
    }


    companion object {
        const val PREF_FILE_NAME = "Scoiolla.pref"
        private val POSITION = "position"

    }
}


