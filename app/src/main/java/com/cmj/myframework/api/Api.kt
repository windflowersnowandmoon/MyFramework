package com.cmj.myframework.api

import android.util.Log
import com.cmj.basiclib.retrofit.BaseApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit


class Api : BaseApi() {
    /**
     * 静态内部类单利
     */
    private class ApiHolder {
        companion object {
            private var api = Api()
            internal final var apiService =
                api.initRetrofit(ApiService.BASE_URL).create(ApiService::class.java)//internal模块内可以用
            internal final var JueJinApiService = api.initRetrofit(ApiService.JUE_JIN_BASE_URL)
                .create(ApiService::class.java)//ApiService.javaClass写这个报错，后面求证
        }
    }

    companion object {
        public fun getInstence(): ApiService {
            return ApiHolder.apiService
        }

        public fun getJueJinInInstance(): ApiService {
            return ApiHolder.JueJinApiService
        }
    }

    override fun setClient(): OkHttpClient? {
        //日志显示级别
        val level = HttpLoggingInterceptor.Level.BODY
        //新建log拦截器
        val loggingInterceptor =
            HttpLoggingInterceptor(HttpLoggingInterceptor.Logger() {
//                fun log(message: String) {
                Log.d("zcb", "OkHttp====Message:$it")
//                }
            })
        loggingInterceptor.level = level
        //OkHttp进行添加拦截器loggingInterceptor
        return OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS) //设置连接超时
            .readTimeout(60, TimeUnit.SECONDS) //设置读超时
            .writeTimeout(60, TimeUnit.SECONDS) //设置写超时
            .retryOnConnectionFailure(true) //是否自动重连
            .addInterceptor(loggingInterceptor)
            /*.addNetworkInterceptor(loggingInterceptor)*/
            .build()
    }
}