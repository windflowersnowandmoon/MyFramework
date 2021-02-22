package com.cmj.myframework.app

import android.widget.Toast
import com.cmj.commonlib.app.AbstractApplication


class MyApp : AbstractApplication() {
    override fun onCreate() {
        super.onCreate()


/*        Thread.setDefaultUncaughtExceptionHandler { thread, ex ->
            Toast.makeText(this, "程序遇到错误:" + ex.message, Toast.LENGTH_LONG).show()
            ex.printStackTrace()
        }*/

    }
}