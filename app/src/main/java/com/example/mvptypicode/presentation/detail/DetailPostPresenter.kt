package com.example.mvptypicode.presentation.detail

import com.example.mvptypicode.callback.GetPostDetailCallBack
import com.example.mvptypicode.domain.PostData
import com.example.mvptypicode.data.respository.PostRepository
import com.example.mvptypicode.data.net.NetworkError
import rx.subscriptions.CompositeSubscription

class DetailPostPresenter(
    private val postRepository: PostRepository,
    private val detailPostView: DetailPostView
) {
    private val subscriptions = CompositeSubscription()
    fun getDetailPost(id: Int) {
        detailPostView.visibleWaiting()
        val subscription = postRepository.getPostDetail(id, object : GetPostDetailCallBack {
            override fun getPostDetailSuccess(postData: PostData) {
                detailPostView.getPostDetailSuccess(postData)
            }

            override fun getPostDetailFailure(networkError: NetworkError) {
                detailPostView.getPostDetailFailure(networkError.getMessage())
            }

        })
        subscriptions.add(subscription)
    }
}