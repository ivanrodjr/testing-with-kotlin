package com.hoolitest.test.endpoints

import com.hoolitest.test.Callback as TestCallback
import com.hoolitest.test.internal.HttpRequest
import com.hoolitest.test.internal.LOCALHOST_ENVIRONMENT
import com.hoolitest.test.internal.LOCALHOST_PORT
import com.hoolitest.test.internal.NetworkCall
import com.hoolitest.test.internal.environmentUrlBuilder
import java.net.UnknownHostException
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Response

class ProductsEndpoint(private val client: OkHttpClient, private val host: String = LOCALHOST_ENVIRONMENT) :
    HttpRequest, NetworkCall {

    private val path = "products"
    private fun endpointUrl() = environmentUrlBuilder(host, path, LOCALHOST_PORT)

    @Throws(UnknownHostException::class)
    fun getProducts(): Response {

        val url = endpointUrl().build()
        val request = get(url)
        return syncCall(client, request)
    }

    @Throws(UnknownHostException::class)
    fun getProducts(callback: TestCallback) {

        val url: HttpUrl = endpointUrl().build()
        val request = get(url)
        asyncCall(client, request, callback)
    }
}
