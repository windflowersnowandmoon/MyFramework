package com.cmj.myframework.ui.test

import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cmj.basiclib.base.BaseActivity
import com.cmj.commonlib.database.AppDatabase
import com.cmj.commonlib.database.Menses
import com.cmj.myframework.R
import kotlinx.android.synthetic.main.activity_my_test.*


class MyTestActivity : BaseActivity<MyTestViewModel>() {

    override fun onCreate(): Int {
       return R.layout.activity_my_test
    }

    override fun initViewModel(): MyTestViewModel {
//        return ViewModelProviders.of(this).get(MyTestViewModel::class.java)
        return ViewModelProvider(this).get(MyTestViewModel::class.java)
    }

    override fun initView() {
       var mMensesDao = AppDatabase.getInstance(this).getMensesdDao()
        var sList: MutableList<Menses> = mutableListOf<Menses>()

        btn_request_data.setOnClickListener {
            viewModel.requstData()
        }

        btn_test_db.setOnClickListener {
            for (index in 1L..10L ){
                var userId = 1 + index
                var m1 = Menses(userId , "Menses1" , "成都1" , userId)
                sList.add(m1)
            }
            mMensesDao.insertAll(sList)
        }
    }

    override fun initData() {
        viewModel.getNewList().observe(this , Observer {
            Toast.makeText(this , "请求完成" , Toast.LENGTH_LONG).show()
        })
    }

    override fun showError(obj: Any?) {

    }
}