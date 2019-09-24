package com.example.mvptypicode.presentation.gallery

import com.example.mvptypicode.domain.PostData

interface GalleryView {
    fun visibleWaiting()
    fun disableWaiting()
    fun getListGallerySuccess(list: List<PostData>)
    fun getListGalleryFailure(error: String)

}