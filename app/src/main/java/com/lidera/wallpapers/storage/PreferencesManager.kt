package com.lidera.wallpapers.storage

import android.content.Context
import android.content.SharedPreferences
import com.lidera.wallpapers.App
import com.lidera.wallpapers.utils.Keys

private const val initIntValue: Int = 0
private const val initBoolValue: Boolean = false

object PreferencesManager {
    private fun getInstance(): SharedPreferences? {
        return App.getInstance().getSharedPreferences(
            App.getInstance().packageName + ".debug0",
            Context.MODE_PRIVATE
        )
    }

    private fun editor(put: (SharedPreferences.Editor?) -> SharedPreferences.Editor?) =
        put(getInstance()?.edit())?.apply()

    /**Screen Width */
    var userScreenWidth: Int
        get() = getInstance()?.getInt(Keys.screenWidth.key, initIntValue)!!
        set(value) = editor { it?.putInt(Keys.screenWidth.key, value) }!!

    /**Screen Height */
    var userScreenHeight: Int
        get() = getInstance()?.getInt(Keys.screenHeight.key, initIntValue)!!
        set(value) = editor { it?.putInt(Keys.screenHeight.key, value) }!!

    /**First Open App */
    var firstOpenApp: Boolean
        get() = getInstance()?.getBoolean(Keys.firstOpenApp.key, initBoolValue)!!
        set(value) = editor { it?.putBoolean(Keys.firstOpenApp.key, value) }!!
}