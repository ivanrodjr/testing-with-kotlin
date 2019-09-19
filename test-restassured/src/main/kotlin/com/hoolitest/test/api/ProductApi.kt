package com.hoolitest.test.api

import com.hoolitest.test.PRODUCTS_ENDPOINT_PATH
import com.hoolitest.test.STATUS_200_RESPONSE_SPEC
import com.hoolitest.test.When
import com.hoolitest.test.dataobjects.ProductResponse
import com.hoolitest.test.deserialize
import com.hoolitest.test.endpointUrlBuilder
import io.restassured.RestAssured.given

class ProductApi {

    val productsEndpoint = endpointUrlBuilder
        .setBasePath(PRODUCTS_ENDPOINT_PATH).build()

    fun getProducts(): ProductResponse {

        val response = given()
            .spec(productsEndpoint)
            .log().all(true)
            .When()
            .get()
            .then()
            .spec(STATUS_200_RESPONSE_SPEC)
            .log().all(true)
            .extract()
            .response()
            .asString()

        return deserialize(response, ProductResponse())
    }
}
