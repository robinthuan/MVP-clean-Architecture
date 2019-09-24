package com.example.mvptypicode.presentation.home

import com.example.mvptypicode.domain.PostData

interface HomeView {
    fun getListPostSuccess(listResponse: List<PostData>)
    fun getListPostFailure(error: String)
    fun visibleWaiting()
    fun disableWaiting()
    fun detailItemPost(position: Int)
}