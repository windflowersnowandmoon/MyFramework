package com.cmj.myframework.api

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 *   $
 *   作   者 :彭付林
 *   邮   箱 :pengfl@kingchannels.com
 *   日   期 :2020/11/19
 *   描   述 :个人信息
 */
class MyHttpLoggingInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        TODO("Not yet implemented")
    }

//    override fun intercept(chain: Interceptor.Chain): Response {
//        val request: Request = chain.request()
//        // try the request
//        val originalResponse = chain.proceed(request)
//
//
//        return null
//
//    }

}