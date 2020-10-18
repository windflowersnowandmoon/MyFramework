package com.cmj.basiclib.base

import android.os.Bundle
import androidx.lifecycle.Observer
import com.cmj.basiclib.lifecycle.BaseViewModel

abstract class BaseActivity<VM : BaseViewModel> : BaseNoModelActivity() {
    protected lateinit  var viewModel : VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = initViewModel()
    }

    /**
     * 初始化ViewModel
     */
    protected abstract fun initViewModel() : VM


    private fun  initObserve(){
        viewModel.getShowDialog(this , Observer {
            if (it.isShow){
                showDialog(it.msg)
            }else{
                dismissDialog()
            }
        })
    }

    /**
     * ViewModel层发生了错误
     */
    protected abstract fun showError(obj: Any?)
}