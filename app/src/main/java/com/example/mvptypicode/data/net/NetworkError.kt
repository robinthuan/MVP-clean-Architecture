package com.example.mvptypicode.data.net

import retrofit2.HttpException

class NetworkError(val error: Throwable?) {
    fun getMessage(): String {
        return error?.message.toString()
    }

    fun getResponseCode(): Int {
        if (error is HttpException) {
            return error.code()
        }
        return 0
    }
}
