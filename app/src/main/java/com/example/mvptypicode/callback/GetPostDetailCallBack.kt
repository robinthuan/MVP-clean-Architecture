package com.example.mvptypicode.callback

import com.example.mvptypicode.domain.PostData
import com.example.mvptypicode.data.net.NetworkError

interface GetPostDetailCallBack {
    fun getPostDetailSuccess(postData: PostData)
    fun getPostDetailFailure(networkError: NetworkError)
}