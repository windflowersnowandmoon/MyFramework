package com.cmj.basiclib.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cmj.basiclib.utils.ActivityUtil

abstract class BaseNoModelActivity : AppCompatActivity() {
    protected lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        setContentView(onCreate())
        ActivityUtil.instance!!.addActivity(this)
        initView()
        initData()
    }

    /**
     * 初始化要加载的布局资源ID
     * 此函数优先执行与onCreate()可以做 window操作
     */
    protected abstract fun onCreate(): Int

    /**
     * 初始化视图
     */
    protected abstract fun initView()

    /**
     * 初始化数据
     */
    protected abstract fun initData()


    override fun onDestroy() {
        super.onDestroy()
        ActivityUtil.instance!!.removeActivtiy(this)
    }
}