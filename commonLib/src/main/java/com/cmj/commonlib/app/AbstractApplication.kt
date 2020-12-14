package com.cmj.commonlib.app

import android.app.Application

class AbstractApplication : Application() {

    private final var abstractApplication : AbstractApplication? = null

    init {
        abstractApplication = this
    }

    public fun getInstance() : AbstractApplication?{
        return abstractApplication
    }

    override fun onCreate() {
        super.onCreate()
    }
}