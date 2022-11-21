package com.lidera.wallpapers.utils

import android.util.Log

enum class LogLevel(val level: String) {
    debug("Debug"),
    error("Error"),
    info("Info")
}

fun log(level: LogLevel, msg: String) {
    when(level) {
        LogLevel.debug ->  Log.d("JHJ:${level.level}", msg)
        LogLevel.error -> Log.e("JHJ:${level.level}", msg)
        LogLevel.info -> Log.i("JHJ:${level.level}", msg)
    }
}