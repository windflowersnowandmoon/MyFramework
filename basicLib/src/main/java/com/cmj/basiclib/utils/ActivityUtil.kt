package com.cmj.basiclib.utils

import android.app.Activity
import java.util.*

class ActivityUtil {
    /**
     *  添加activity
     */
    @Synchronized
    fun addActivity(activity: Activity) {
        stack!!.add(activity)
    }

    /**
     * 移除activity
     */
    @Synchronized
    fun removeActivtiy(activity: Activity) {
        stack!!.remove(activity)
    }

    /**
     * 结束指定类目的activity
     */
    fun finishActivity(clazz: Class<*>) {
        for (activity in stack!!) {
            if (activity.javaClass == clazz) {
                finishActivity(activity)
                return
            }
        }
    }

    /**
     * 结束指定的activity
     */
    fun finishActivity(activity: Activity) {
        if (activity != null) {
            activity.finish()
            stack!!.remove(activity)
        }
    }

    /**
     * 是否存在activity
     */
    fun containsActivity(clazz: Class<*>): Boolean {
        for (activity in stack!!) {
            if (activity.javaClass == clazz) {
                return true
            }
        }
        return false
    }

    /**
     * 结束所有activity
     */
    fun finishAllActivity() {
        for (activity in stack!!) {
            activity?.finish()
        }
        stack!!.clear()
    }

    public companion object {
        private var stack: Stack<Activity>? = null
        private var manager: ActivityUtil? = null

        /**
         * 获取实例
         */
        @get:Synchronized
        val instance: ActivityUtil?
            get() {
                if (manager == null) {
                    manager = ActivityUtil()
                    stack = Stack()
                }
                return manager
            }
    }


}