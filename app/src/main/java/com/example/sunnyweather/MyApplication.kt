package com.example.sunnyweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        mContext = applicationContext
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var mContext: Context

        const val TOKEN = "tvYZ25k0H5buimeU"
    }
}