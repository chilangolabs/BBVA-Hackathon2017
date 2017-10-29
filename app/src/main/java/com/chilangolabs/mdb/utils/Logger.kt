package com.chilangolabs.mdb.utils

import android.util.Log

/**
 * @author Gorro.
 */

object Logger {

    var isDebug = true

}

fun Any.loge(msg: Any, thr: Throwable? = null) {
    if (Logger.isDebug) {
        Log.e(this::class.java.simpleName, "$msg", thr)
    }
}

fun Any.logi(msg: Any, thr: Throwable? = null) {
    if (Logger.isDebug) {
        Log.i(this::class.java.simpleName, "$msg", thr)
    }
}

fun Any.logd(msg: Any, thr: Throwable? = null) {
    if (Logger.isDebug) {
        Log.d(this::class.java.simpleName, "$msg", thr)
    }
}

fun Any.logw(msg: Any, thr: Throwable? = null) {
    if (Logger.isDebug) {
        Log.w(this::class.java.simpleName, "$msg", thr)
    }
}

fun Any.logv(msg: Any, thr: Throwable? = null) {
    if (Logger.isDebug) {
        Log.v(this::class.java.simpleName, "$msg", thr)
    }
}

fun Any.loga(msg: Any, thr: Throwable? = null) {
    if (Logger.isDebug) {
        Log.wtf(this::class.java.simpleName, "$msg", thr)
    }
}