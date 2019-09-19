package com.hoolitest.test

import com.hoolitest.test.api.ProductApi
import com.hoolitest.test.api.ProductApiDsl
import io.restassured.RestAssured
import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

class ProductsApiTest {

    init {
        RestAssured.baseURI = LOCALHOST_ENVIRONMENT
        RestAssured.port = 3030
    }

    private val productApi = ProductApi()
    private val productApiDsl = ProductApiDsl()

    @Test(groups = ["api"])
    fun `test calling the products api returns a valid response`() {

        val response = productApi.getProducts()
        assertThat(response.limit).`as`("Query Limit").isEqualTo(10)
        assertThat(response.data.size).`as`("Amount of Categories").isEqualTo(10)
    }

    @Test(groups = ["api"])
    fun `test calling the products api with dsl returns a valid response`() {

        val response = productApiDsl.getProducts()
        assertThat(response.limit).`as`("Query Limit").isEqualTo(10)
        assertThat(response.data.size).`as`("Amount of Categories").isEqualTo(10)
    }
}
