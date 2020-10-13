package com.cmj.basiclib.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.cmj.basiclib.view.LoadingDialog

abstract class BaseNoModelFragment : Fragment(){
    protected var mContext : Context? = null
    private lateinit var mActivity : FragmentActivity
    private var loadingDialog : LoadingDialog? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
        mActivity = activity!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(onCreate() , container , false)
        initView(view)
        return view
    }

    /**
     * 初始化要价在的布局资源ID
     */
    protected abstract fun onCreate():Int

    /**
     * 初始化视图
     */
    protected abstract fun initView(view : View)

    /**
     * 初始化数据
     */
    protected abstract fun initData()

    /**
     * 显示用户等待框
     */
    protected fun showDialog(msg : String){
        if (loadingDialog != null && loadingDialog!!.isShowing){
            loadingDialog!!.setLoadingMsg(msg)
        } else {
           loadingDialog = LoadingDialog(mContext!!)
            loadingDialog!!.setLoadingMsg(msg)
            loadingDialog!!.show()
        }
    }

    /**
     * 隐藏对话框
     */
    protected fun dismissDialog(){
        if (loadingDialog != null && loadingDialog!!.isShowing){
            loadingDialog!!.dismiss()
            loadingDialog = null
        }
    }
}