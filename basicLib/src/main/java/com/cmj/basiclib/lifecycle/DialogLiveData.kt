package com.cmj.basiclib.lifecycle

import androidx.lifecycle.MutableLiveData
import com.cmj.basiclib.bean.DialogBean

@Suppress("UNCHECKED_CAST")//消除警告提醒
public final class DialogLiveData<T> : MutableLiveData<T>() {
    private var bean: DialogBean = DialogBean()

    public fun setValue(isShow: Boolean) {
        bean.isShow = isShow
        bean.msg = ""
        value = bean as T
    }

    public fun setValue(isShow: Boolean, msg: String) {
        bean.isShow = isShow
        bean.msg = msg
        value = bean as T
    }
}