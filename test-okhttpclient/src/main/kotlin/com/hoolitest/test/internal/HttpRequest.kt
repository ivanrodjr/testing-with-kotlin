package com.hoolitest.test.internal

import okhttp3.HttpUrl
import okhttp3.RequestBody

internal interface HttpRequest {

    fun post(url: HttpUrl, requestBody: RequestBody) = requestBuilder()
        .url(url)
        .post(requestBody)
        .build()

    fun get(url: HttpUrl) = requestBuilder()
        .url(url)
        .build()

    fun delete(url: HttpUrl) = requestBuilder()
        .url(url)
        .delete()
        .build()

    fun put(url: HttpUrl, requestBody: RequestBody) = requestBuilder()
        .url(url)
        .put(requestBody)
        .build()
}
