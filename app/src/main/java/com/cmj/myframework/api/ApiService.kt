package com.cmj.myframework.api

import com.cmj.myframework.ui.test.NewsBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    companion object{
        const val  BASE_URL = "https://news-at.zhihu.com/api/4/"
        const val JUE_JIN_BASE_URL = "http://timeline-merger-ms.juejin.im/v1/"
    }

    /**
     * 测试接口
     */
    @GET("news/latest")
    fun news(): Observable<NewsBean>

    /**
     * 掘金接口
     */
    @GET("get_entry_by_timeline")
    fun jueJin(@Query("category") category : String , @Query("limit")  limit : String,
               @Query("src") src : String )
}