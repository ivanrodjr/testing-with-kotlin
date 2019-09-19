package com.hoolitest.test

import java.io.IOException
import okhttp3.Call
import okhttp3.Response

interface Callback {

    fun onResponse(call: Call, response: Response)
    fun onFailure(call: Call, e: IOException)
}
