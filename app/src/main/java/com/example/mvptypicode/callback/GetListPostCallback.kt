package com.example.mvptypicode.callback

import com.example.mvptypicode.domain.PostData
import com.example.mvptypicode.data.net.NetworkError

interface GetListPostCallback {
    fun getListPostSuccess(listResponse: List<PostData>)
    fun getListPostFailure(networkError: NetworkError)
}