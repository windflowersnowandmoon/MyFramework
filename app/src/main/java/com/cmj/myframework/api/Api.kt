package com.cmj.myframework.api

import com.cmj.basiclib.retrofit.BaseApi
import okhttp3.OkHttpClient

class Api : BaseApi(){
    /**
     * 静态内部类单利
     */
    private class ApiHolder{
        companion object{
            private var api = Api()
            internal final var apiService = api.initRetrofit(ApiService.BASE_URL).create(ApiService::class.java)//internal模块内可以用
            internal final var JueJinApiService = api.initRetrofit(ApiService.JUE_JIN_BASE_URL).create(ApiService::class.java)//ApiService.javaClass写这个报错，后面求证
        }
    }

    companion object{
        public fun getInstence(): ApiService {
            return ApiHolder.apiService
        }

        public fun  getJueJinInInstance() : ApiService{
            return ApiHolder.JueJinApiService
        }
    }

    override fun setClient(): OkHttpClient? {
        return null
    }
}