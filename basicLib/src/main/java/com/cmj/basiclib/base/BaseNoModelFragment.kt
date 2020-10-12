package com.cmj.basiclib.base

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

class BaseNoModelFragment : Fragment(){
    protected var mContext : Context? = null
    private lateinit var mActivity : FragmentActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
        mActivity = activity!!
    }
}