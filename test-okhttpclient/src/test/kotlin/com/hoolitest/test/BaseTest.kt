package com.hoolitest.test

import com.google.gson.GsonBuilder

abstract class BaseTest {

    /**
     * Helper function to get test data Json
     * to avoid instantiate a model class xD
     * Will send the json directly without
     * model validation.
     *
     * @param path : Path of JSON file
     * @return json : JSON from file at given path
     */
    fun getJson(path: String): String? = this::class.java.classLoader?.getResource(path)?.readText()

    /**
     * Helper function to get test data Json
     * to avoid initialize a model class xD
     * Will parse the json to its corresponding
     * model.
     *
     *
     * @param path : Path of JSON file
     * @param classModel : The corresponding data class
     * @return json : JSON from file at given path
     */
    fun <T : Any> getJson(path: String, classModel: T): T {
        val file: String? = this::class.java.classLoader?.getResource(path)?.readText()
        return GsonBuilder().setPrettyPrinting().create().fromJson(file, classModel::class.java)
    }

    fun <T : Any> deserialize(body: String?, classModel: T): T = GsonBuilder().setPrettyPrinting().create()
        .fromJson(body, classModel::class.java)
}
