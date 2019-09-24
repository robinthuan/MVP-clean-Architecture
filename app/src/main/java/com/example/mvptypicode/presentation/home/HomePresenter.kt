package com.example.mvptypicode.presentation.home

import com.example.mvptypicode.callback.GetListPostCallback
import com.example.mvptypicode.domain.PostData
import com.example.mvptypicode.data.respository.PostRepository
import com.example.mvptypicode.data.net.NetworkError
import rx.subscriptions.CompositeSubscription

class HomePresenter(private val postRepository: PostRepository, val homeView: HomeView) {
    var subscriptions = CompositeSubscription()
    fun getListPost() {
        homeView.visibleWaiting()
        val subscription = postRepository.getListPost(object : GetListPostCallback {
            override fun getListPostSuccess(listResponse: List<PostData>) {
                homeView.getListPostSuccess(listResponse)
            }

            override fun getListPostFailure(networkError: NetworkError) {
                homeView.getListPostFailure(networkError.getMessage())
            }

        })
        subscriptions.add(subscription)
    }
}