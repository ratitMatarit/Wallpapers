package com.lidera.wallpapers.screens.DisplayMetrics

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.graphics.Point
import android.os.Build
import android.view.WindowManager
import androidx.lifecycle.ViewModel
import java.util.*

class DisplayMetricViewModel : ViewModel() {

    var screenWidth: Int = 0
    var screenHeight: Int = 0

    fun getDisplaySize(activity: Activity) {
        val x: Int
        val y: Int
        val orientation = activity.resources.configuration.orientation
        val wm = activity.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val screenSize = Point()
        display.getRealSize(screenSize)
        x = screenSize.x
        y = screenSize.y
        screenWidth = if (orientation == Configuration.ORIENTATION_PORTRAIT) x else y
        screenHeight = if (orientation == Configuration.ORIENTATION_PORTRAIT) y else x
    }

    fun getDeviceName(): String {
        val manufacturer = Build.MANUFACTURER
        val model = Build.MODEL
        return if (model.lowercase(Locale.getDefault())
                .startsWith(manufacturer.lowercase(Locale.getDefault()))
        ) {
            capitalize(model)
        } else {
            capitalize(manufacturer) + " " + model
        }
    }

    private fun capitalize(s: String?): String {
        if (s == null || s.isEmpty()) {
            return ""
        }
        val first = s[0]
        return if (Character.isUpperCase(first)) {
            s
        } else {
            first.uppercaseChar().toString() + s.substring(1)
        }
    }
}