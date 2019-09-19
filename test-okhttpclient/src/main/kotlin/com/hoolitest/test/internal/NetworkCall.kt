package com.hoolitest.test.internal

import com.hoolitest.test.Callback as TestCallback
import java.io.IOException
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

internal interface NetworkCall {

    fun syncCall(client: OkHttpClient, request: Request) = client.newCall(request).execute()

    fun asyncCall(client: OkHttpClient, request: Request, callback: TestCallback) {

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                callback.onFailure(call, e)
            }

            override fun onResponse(call: Call, response: Response) {
                callback.onResponse(call, response)
            }
        })
    }
}
