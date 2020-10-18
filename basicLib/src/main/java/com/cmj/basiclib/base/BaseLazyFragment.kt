package com.cmj.basiclib.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cmj.basiclib.lifecycle.BaseViewModel

/**
 * 描述 懒加载Fragment基类，适用于页面多个Tab页面
 */
abstract class BaseLazyFragment<VM : BaseViewModel> : BaseFragment<VM>() {

    /**
     * 懒加载
     */
    private var createView = false
    private  var activityCreated  = false
    private  var lazy  = false

    /**
     * 这个Fragment是不是tab页面的第一个页面
     */
    private var isFirstTab = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = super.onCreateView(inflater, container, savedInstanceState)
        createView = true
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activityCreated = true
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser && createView && activityCreated && !lazy){
            //不是第一个tab的fragment进行加载请求数据
            lazy = true
            lazyLoad()
        }else if (isVisibleToUser && !createView && !activityCreated && !lazy){
            //这个Fragment是多个Tab中的第一个
            isFirstTab = true
        }else {
            //对用户可见时，是否需要重新刷新数据
            if (isVisibleToUser) {
                visibleToUser()
            }
        }
    }

    /**
     * 懒加载，只有在Fragment第一次创建且第一次对用户可见
     */
    protected abstract fun lazyLoad()

    /**
     * 每次在Fragment与用户可见状态且不是第一次对用户可见
     */
    protected abstract fun visibleToUser()
}