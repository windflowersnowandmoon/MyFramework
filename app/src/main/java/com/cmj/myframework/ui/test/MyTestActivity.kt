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

        var m1 = Menses("骑驴去看海" , "飞翔的小鸟" , 23)
        //插入单个对象
        btn_test_db.setOnClickListener {
            mMensesDao.insertElement(m1)
        }

        //插入一个集合
        btn_test_db1.setOnClickListener {
            for (index in 1L..10L ){
                var userId = 1 + index
                var m1 = Menses("Menses1" , "成都1" , userId)
                sList.add(m1)
            }
            mMensesDao.insertAll(sList)
            sList.removeAll(sList)
        }

        //查询单个对象
        btn_test_db2.setOnClickListener {
          var menses =  mMensesDao.getMenses(2)
            Toast.makeText(this@MyTestActivity , "我的用户id = ${menses.userId}" , Toast.LENGTH_SHORT).show()
        }

        //查询集合
        btn_test_db3.setOnClickListener {
            var mensesList =  mMensesDao.getMensesList()
            Toast.makeText(this@MyTestActivity , "集合个数 = ${mensesList.size}" , Toast.LENGTH_SHORT).show()
        }

        //更新对象
        btn_test_db4.setOnClickListener {
            var menses = Menses("Menses蓉城" , "成都蓉城" , 23)
            mMensesDao.updateMenses(7 , "Menses蓉城" , "成都蓉城")
        }

        btn_test_db5.setOnClickListener {
            mMensesDao.updateMensesList(21 , "Menses蓉城" , "成都蓉城")
        }
        btn_test_db6.setOnClickListener {
            /**
             * 删除对象和里面的其他字段没关系，只和主键有关，主键值一样的就会被删除
             */
            var menses = Menses("Menses蓉城" , "成都蓉城" , 23)
            menses.id = 32
            mMensesDao.deleteElement(menses)
        }
        btn_test_db7.setOnClickListener {
//            mMensesDao.deleteList(sList)//这样无法删除，因为主键没有值
            mMensesDao.deleteList()
        }
        btn_test_db8.setOnClickListener {
            mMensesDao.deleteAll()
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