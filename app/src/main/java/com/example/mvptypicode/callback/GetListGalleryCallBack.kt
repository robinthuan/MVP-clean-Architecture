package com.example.mvptypicode.callback

import com.example.mvptypicode.domain.PostData
import com.example.mvptypicode.data.net.NetworkError

interface GetListGalleryCallBack {
    fun getListGallerySuccess(list: List<PostData>)
    fun getListGalleryFailure(networkError: NetworkError)
}