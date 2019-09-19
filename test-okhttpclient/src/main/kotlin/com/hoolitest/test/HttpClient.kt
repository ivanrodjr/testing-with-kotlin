package com.hoolitest.test

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response

object HttpClient {

    @JvmStatic
    val client: (token: String) -> OkHttpClient = { token -> OkHttpClient()
        .newBuilder()
        .addInterceptor(object : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain
                .request()
                .newBuilder()
                .addHeader("Authorization", token)
                .build()

            return chain.proceed(request = request)
        }
    }).build() }
}
