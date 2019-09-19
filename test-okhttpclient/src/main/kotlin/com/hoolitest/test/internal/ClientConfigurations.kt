package com.hoolitest.test.internal

import com.google.gson.Gson
import java.net.UnknownHostException
import okhttp3.HttpUrl
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

internal const val API_PATH = "api"
internal const val V2_PATH = "v2"
internal const val LOCALHOST_ENVIRONMENT = "localhost"
internal const val LOCALHOST_PORT = 8080

@JvmName("nullableInt")
internal fun Int?.isNullParam() = run { this ?: "" }
internal fun Long?.isNullParam() = run { this ?: "" }
internal fun urlBuilder(): HttpUrl.Builder = HttpUrl.Builder()

internal fun requestBuilder(): Request.Builder = Request
    .Builder()
    .header("Content-Type", "application/json")

internal fun <T : Any> Gson.modelToJsonRequestBody(classModel: T): RequestBody = newBuilder()
    .setPrettyPrinting()
    .create()
    .toJson(classModel)
    .toRequestBody("application/json; charset=utf-8".toMediaType())

internal fun Gson.toJsonRequestBody(jsonBody: String): RequestBody = newBuilder()
    .setPrettyPrinting()
    .create()
    .toJson(jsonBody)
    .toRequestBody("application/json; charset=utf-8".toMediaType())

internal val exceptionMessage: (host: String) -> String = { host -> "Invalid host: $host. For a valid host see: https://aliant.docs.stoplight.io/" }

internal fun environmentUrlBuilder(host: String, path: String, port: Int) = when (host) {

    LOCALHOST_ENVIRONMENT -> urlBuilder()
        .scheme("http")
        .host(host)
        .port(port)
        .addPathSegment(path)

    else -> throw UnknownHostException(exceptionMessage(host))
}
