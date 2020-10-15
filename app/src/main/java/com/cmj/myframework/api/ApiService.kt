package com.cmj.myframework.api

open interface ApiService {
    var asd: String?

    companion object{
        const val  BASE_URL: String = "https://news-at.zhihu.com/api/4/"
        const val JUE_JIN_BASE_URL: String = "http://timeline-merger-ms.juejin.im/v1/"
    }

}