package com.cmj.myframework.api

open interface ApiService {
    companion object{
        var BASE_URL: String
            get() = "https://news-at.zhihu.com/api/4/"
            set(value) {BASE_URL = value}

        var JUE_JIN_BASE_URL: String
            get() = "http://timeline-merger-ms.juejin.im/v1/"
            set(value) {JUE_JIN_BASE_URL = value}
    }

}