package com.hoolitest.test

import com.hoolitest.test.endpoints.ProductsEndpoint
import com.hoolitest.test.internal.LOCALHOST_PORT
import java.io.IOException
import okhttp3.Call
import okhttp3.Response
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.testng.annotations.Test

class ProductsEndpointTest : BaseTest() {

    private val server = MockWebServer().apply { start(port = LOCALHOST_PORT) }
    private val path = "/"
    private val serverUrl = server.url(path)
    private val productsResponse = getJson(PRODUCTS_RESPONSE_PATH)
    private val productsEndpoint = ProductsEndpoint(client = TestHttpClient.testClient)

    @Test(groups = ["unit", "products"])
    fun `test getting products should send a valid sync request`() {

        // Setup | Le inserto un response mockeado al server
        productsResponse?.let { MockResponse().setBody(it) }?.let { server.enqueue(it) }

        // Execution | Hago el request asyncrono
        productsEndpoint.getProducts()
        val outgoingRequest = server.takeRequest()

        // Assertion | Valido la estructura del request
        val softly = SoftEndpointRequestAssert()
        softly.assertThat(outgoingRequest)
            ?.requestPathIs("/products")
            ?.requestMethodIs(GET)
            ?.headerIsPresent(CONTENT_TYPE, APPLICATION_JSON)
            ?.requestUrl("${serverUrl}products")
        softly.assertAll()
    }

    @Test(groups = ["unit", "products"])
    fun `test getting products should send a valid async request`() {

        // Setup | Le inserto un response mockeado al server
        productsResponse?.let { MockResponse().setBody(it) }?.let { server.enqueue(it) }

        // Execution | Hago el request asyncrono
        productsEndpoint.getProducts(callback = object : Callback {

            override fun onResponse(call: Call, response: Response) {

                // Deserializamos y tenemos acceso al body completo
                deserialize(response.body?.string(), ProductResponse()).also {

                    println("""Categorias del objeto deserializado: 
                        |
                        |${it.data[1].categories}""".trimMargin())
                }
            }
            override fun onFailure(call: Call, e: IOException) {

                // Manejar request fallidos
            }
        })
        val outgoingRequest = server.takeRequest()

        // Assertion | Valido la estructura del request
        val softly = SoftEndpointRequestAssert()
        softly.assertThat(outgoingRequest)
            ?.requestPathIs("/products")
            ?.requestMethodIs(GET)
            ?.headerIsPresent(CONTENT_TYPE, APPLICATION_JSON)
            ?.requestUrl("${serverUrl}products")
        softly.assertAll()
    }
}
