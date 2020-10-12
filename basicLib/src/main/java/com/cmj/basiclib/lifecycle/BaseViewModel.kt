package com.cmj.basiclib.lifecycle

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.cmj.basiclib.bean.DialogBean
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class BaseViewModel : ViewModel() {
    /**
     * 管理 RxJava请求
     */
    private var compositeDisposable: CompositeDisposable? = null

    /**
     * 用来通知Activity/Fragment 是否显示等待Dialog
     */
    protected var showDialog = DialogLiveData<DialogBean>()

    /**
     * 当 ViewModel层出现错误需要通知到Activity / Fragment
     */
    protected var error: MutableLiveData<Any>? = MutableLiveData()

    /**
     * 添加rxJava 发出的请求
     */
    protected fun addDisposable(disposable: Disposable) {
        if (compositeDisposable == null || compositeDisposable!!.isDisposed) {
            compositeDisposable = CompositeDisposable()
        }
        compositeDisposable!!.add(disposable)
    }

    public fun getShowDialog(owner: LifecycleOwner, observer: Observer<DialogBean>) {
        showDialog.observe(owner, observer)
    }

    public fun getError(owner: LifecycleOwner, observer: Observer<Any>) {
        error!!.observe(owner, observer)
    }

    override fun onCleared() {
        super.onCleared()
        if (compositeDisposable != null) {
            compositeDisposable!!.dispose();
            compositeDisposable = null
        }
        error = null
    }
}