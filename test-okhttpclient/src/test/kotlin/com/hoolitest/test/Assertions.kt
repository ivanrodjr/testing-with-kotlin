package com.hoolitest.test

import okhttp3.mockwebserver.RecordedRequest
import org.assertj.core.api.AbstractAssert
import org.assertj.core.api.SoftAssertions

open class EndpointRequestAssert(recordedRequest: RecordedRequest) : AbstractAssert<EndpointRequestAssert, RecordedRequest>
    (recordedRequest, EndpointRequestAssert::class.java) {

    companion object {
        fun assertThat(actual: RecordedRequest): EndpointRequestAssert {
            return EndpointRequestAssert(actual)
        }
    }

    fun requestPathIs(path: String): EndpointRequestAssert {

        if (actual.path != path) failWithMessage("Expected request path to be $path but was ${actual.path}")
        return this
    }

    fun requestMethodIs(method: String): EndpointRequestAssert {

        if (actual.method != method) failWithMessage("Expected request method to be $method but was ${actual.method}")
        return this
    }

    fun headerIsPresent(actualHeader: String, expectedHeader: String): EndpointRequestAssert {

        val nullHeader = "Request does not contain a header of type $actualHeader"
        val differentHeaderValue = """Expected $actualHeader header with value: $expectedHeader
            |but instead the value was ${actual.getHeader(actualHeader)}""".trimMargin()

        when {
            actual.getHeader(actualHeader) == null -> failWithMessage(nullHeader)
            actual.getHeader(actualHeader) != expectedHeader -> failWithMessage(differentHeaderValue)
        }
        return this
    }

    fun requestUrl(url: String): EndpointRequestAssert {

        if ("${actual.requestUrl}" != url) failWithMessage("Expected request URL to be $url but was ${actual.requestUrl}")
        return this
    }
}

class SoftEndpointRequestAssert : SoftAssertions() {

    fun assertThat(actual: RecordedRequest): EndpointRequestAssert? =
        proxy(EndpointRequestAssert::class.java, RecordedRequest::class.java, actual)
}
