package com.hoolitest.test

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

// Http methods
const val GET = "GET"
const val POST = "POST"
const val PUT = "PUT"
const val DELETE = "DELETE"

// Header types
const val CONTENT_TYPE = "Content-Type"
const val AUTHORIZATION = "Authorization"

// Header values
const val BEARER_TOKEN = "Bearer eyJhbGciOiJIUz"
const val APPLICATION_JSON = "application/json"
const val APPLICATION_JSON_UTF8 = "$APPLICATION_JSON; charset=utf-8"

// Json mock test data
const val CUSTOMER_BODY = "testdata/CustomersBody.json"
const val PRODUCTS_RESPONSE_PATH = "testdata/ProductsResponse.json"

object TestHttpClient {

    private val loggingInterceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

    @JvmStatic val testClient = OkHttpClient().newBuilder().addInterceptor(loggingInterceptor).build()
}
