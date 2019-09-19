@file:JvmName("ModelDataObjects")

package com.hoolitest.test.dataobjects
import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("data")
    val `data`: List<Data> = listOf(),
    @SerializedName("limit")
    val limit: Int = 0,
    @SerializedName("skip")
    val skip: Int = 0,
    @SerializedName("total")
    val total: Int = 0
)

data class Data(
    @SerializedName("categories")
    val categories: List<Category> = listOf(),
    @SerializedName("createdAt")
    val createdAt: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("image")
    val image: String = "",
    @SerializedName("manufacturer")
    val manufacturer: String = "",
    @SerializedName("model")
    val model: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("price")
    val price: Double = 0.0,
    @SerializedName("shipping")
    val shipping: Int = 0,
    @SerializedName("type")
    val type: String = "",
    @SerializedName("upc")
    val upc: String = "",
    @SerializedName("updatedAt")
    val updatedAt: String = "",
    @SerializedName("url")
    val url: String = ""
)

data class Category(
    @SerializedName("createdAt")
    val createdAt: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("updatedAt")
    val updatedAt: String = ""
)
