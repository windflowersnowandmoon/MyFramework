package com.cmj.myframework

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toTest.setOnClickListener( View.OnClickListener {
            /*val intent = Intent()
            //获取intent对象
            intent.setClass(this , MyTestActivity::class.java)
            // 获取class是使用::反射
            startActivity(intent)*/

            val arr = arrayOf(1, 2, 3)
            var asd = arr[4]
        })
    }
}