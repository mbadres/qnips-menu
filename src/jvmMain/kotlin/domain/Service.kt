package domain

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.OkHttpClient
import okhttp3.Request

fun getMenu(): Menu {

    val baseUrl = "https://my.qnips.io/dbapi/ha/"

    val request = Request
        .Builder()
        .url(baseUrl)
        .get()
        .build()

    val result = OkHttpClient()
        .newCall(request)
        .execute()
        .body!!
        .string()

    return jacksonObjectMapper().readValue(result)
}
