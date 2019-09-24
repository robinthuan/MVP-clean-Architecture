package com.example.mvptypicode.presentation.detail

import com.example.mvptypicode.domain.PostData

interface DetailPostView {
    fun visibleWaiting()
    fun disableWaiting()
    fun getPostDetailSuccess(postData: PostData)
    fun getPostDetailFailure(error: String)
}