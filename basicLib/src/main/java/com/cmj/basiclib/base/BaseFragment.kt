package com.cmj.basiclib.base

import android.os.Bundle
import androidx.lifecycle.Observer
import com.cmj.basiclib.bean.DialogBean
import com.cmj.basiclib.lifecycle.BaseViewModel

/**
 * 描述 ViewModel、ViewBinding都需要的基类
 */
open abstract class BaseFragment<VM : BaseViewModel> : BaseNoModelFragment(){
    protected var viewModel : VM ? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = initViewModel()
        initObserve()
        super.onActivityCreated(savedInstanceState)
    }

    /**
     * 初始化ViewModel
     */
    protected abstract fun initViewModel () : VM

    /**
     * 监听当前ViewModel中 showDialog和error的值
     */
    private fun initObserve(){
        if (viewModel == null)return
        viewModel!!.getShowDialog(this , Observer<DialogBean>{
            if (it.isShow){
                showDialog(it.msg)
            }else{
                dismissDialog()
            }
        })
    }

    /**
     *  ViewModel层发生来了错误
     */
    protected abstract fun showError(obj : Any)
}