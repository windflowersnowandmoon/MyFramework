package com.cmj.myframework.ui.tests

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.cmj.myframework.R
import kotlinx.android.synthetic.main.activity_image.*

class ImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        Glide.with(this@ImageActivity)
            .load("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1608214933&di=2eb93fdd4634ec055eacd7abd1480760&src=http://a2.att.hudong.com/27/81/01200000194677136358818023076.jpg")
            .into(test_glide)
    }

}