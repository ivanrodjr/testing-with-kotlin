package com.hoolitest.test.api

import com.hoolitest.test.PRODUCTS_ENDPOINT_PATH
import com.hoolitest.test.STATUS_200_RESPONSE_SPEC
import com.hoolitest.test.dataobjects.ProductResponse
import com.hoolitest.test.deserialize
import com.hoolitest.test.endpointUrlBuilder
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When

class ProductApiDsl {

    val productsEndpoint = endpointUrlBuilder
        .setBasePath(PRODUCTS_ENDPOINT_PATH).build()

    fun getProducts(): ProductResponse {

        val response =

            Given {
                spec(productsEndpoint)
                log().all()
            } When {
                get()
            } Then {
                spec(STATUS_200_RESPONSE_SPEC)
                header("Content-Type", "application/json; charset=utF-8")
                log().all()
            } Extract {
                response().asString()
            }

        return deserialize(response, ProductResponse())
    }
}
