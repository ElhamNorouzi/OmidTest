package com.data.base.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor(): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer YOUR_TOKEN_HERE")
            .addHeader("Content-Type", "application/json")
            .build()
        return chain.proceed(request)
    }
}