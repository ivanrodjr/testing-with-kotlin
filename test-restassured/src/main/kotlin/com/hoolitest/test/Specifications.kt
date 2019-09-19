package com.hoolitest.test

import com.google.gson.GsonBuilder
import io.restassured.builder.RequestSpecBuilder
import io.restassured.builder.ResponseSpecBuilder
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification
import io.restassured.specification.ResponseSpecification

// url and paths
const val LOCALHOST_ENVIRONMENT = "http://localhost"
const val PRODUCTS_ENDPOINT_PATH = "/products"

// headers
const val AUTHORIZATION_HEADER = "Authorization"

val STATUS_200_RESPONSE_SPEC: ResponseSpecification = ResponseSpecBuilder()
    .expectContentType(ContentType.JSON)
    .expectStatusCode(200)
    .build()

val STATUS_201_RESPONSE_SPEC: ResponseSpecification = ResponseSpecBuilder()
    .expectContentType(ContentType.JSON)
    .expectStatusCode(201)
    .build()

val STATUS_202_RESPONSE_SPEC: ResponseSpecification = ResponseSpecBuilder()
    .expectContentType(ContentType.JSON)
    .expectStatusCode(202)
    .build()

fun <T : Any> deserialize(jsonBody: String, classModel: T): T = GsonBuilder().setPrettyPrinting().create()
    .fromJson(jsonBody, classModel::class.java)

fun RequestSpecification.When(): RequestSpecification = this.`when`()

val endpointUrlBuilder: RequestSpecBuilder = RequestSpecBuilder()
    .setContentType(ContentType.JSON)
