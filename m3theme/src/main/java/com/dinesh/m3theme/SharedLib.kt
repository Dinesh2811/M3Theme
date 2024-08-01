package com.dinesh.m3theme

import android.util.Log


private val TAG = "log_" + SharedLib::class.java.name.split(SharedLib::class.java.name.split(".").toTypedArray()[2] + ".").toTypedArray()[1]

class SharedLib {
    fun test() {
        Log.d(TAG, "test: ")
    }
}