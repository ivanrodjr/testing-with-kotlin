package com.hoolitest.test

import com.hoolitest.test.api.ProductApi
import com.hoolitest.test.api.ProductApiDsl
import com.hoolitest.test.dataobjects.ProductResponse
import io.restassured.RestAssured
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

class ProductsApiTest2 {

    init {
        RestAssured.baseURI = LOCALHOST_ENVIRONMENT
        RestAssured.port = 3030
    }

    private val productApi = ProductApi()
    private val productApiDsl = ProductApiDsl()

    @Test(groups = ["api"])
    fun `test calling the products api returns a valid response`() {

        val response = RestAssured.given()
            .spec(productApi.productsEndpoint)
            .log().all(true)
            .When()
            .get()
            .then()
            .spec(STATUS_200_RESPONSE_SPEC)
            .log().all(true)
            .extract()
            .response()
            .asString()

        val responseObject = deserialize(response, ProductResponse())

        assertThat(responseObject.limit).`as`("Query Limit").isEqualTo(10)
        assertThat(responseObject.data.size).`as`("Amount of Categories").isEqualTo(10)
    }

    @Test(groups = ["api"])
    fun `test calling the products api with dsl returns a valid response`() {

        Given {
            spec(productApiDsl.productsEndpoint)
            log().all()
        } When {
            get()
        } Then {
            spec(STATUS_200_RESPONSE_SPEC)
            header("Content-Type", "application/json; charset=utF-8")
            log().all()
        }
    }
}
