package com.cmj.myframework.ui.test

import androidx.lifecycle.MutableLiveData
import com.cmj.basiclib.lifecycle.BaseViewModel
import com.cmj.myframework.api.Api
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class MyTestViewModel : BaseViewModel(){

    /**
     * 当数据请求成功回调
     */
    protected var news = MutableLiveData<NewsBean>()

    public fun requstData() {
        showDialog.setValue(true , "加载中")

        var disposable = Api.getInstence().news()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                showDialog.setValue(false)
                news.value = it
            }, {
                showDialog.setValue(false)
                error!!.value = "发生错误"
            })
        addDisposable(disposable)
    }

    public fun getNewList(): MutableLiveData<NewsBean> {
        return news
    }
}