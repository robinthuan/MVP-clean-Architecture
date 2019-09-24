package com.example.mvptypicode.presentation.gallery

import com.example.mvptypicode.callback.GetListGalleryCallBack
import com.example.mvptypicode.domain.PostData
import com.example.mvptypicode.data.respository.PostRepository
import com.example.mvptypicode.data.net.NetworkError
import rx.subscriptions.CompositeSubscription

class GalleryPresenter(private val postRepository: PostRepository, private val galleryView: GalleryView) {
    private val subscriptions = CompositeSubscription()
    fun getListGallery() {
        galleryView.visibleWaiting()
        val subscription = postRepository.getListGallery(object : GetListGalleryCallBack {
            override fun getListGallerySuccess(list: List<PostData>) {
                galleryView.getListGallerySuccess(list)
            }

            override fun getListGalleryFailure(networkError: NetworkError) {
                galleryView.getListGalleryFailure(networkError.getMessage())
            }
        })
        subscriptions.add(subscription)
    }
}