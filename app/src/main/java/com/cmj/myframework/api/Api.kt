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
            private final var apiService = api.initRetrofit(ApiService.BASE_URL)
        }
    }


    override fun setClient(): OkHttpClient? {
        return null
    }
}