package com.example.mvptypicode.di.module

import com.example.mvptypicode.data.net.ApiProvider
import com.example.mvptypicode.data.respository.PostRepository
import com.example.mvptypicode.data.net.NetworkService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiProvider.BASE_URL)
            //  .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            // .addConverterFactory(ScalarsConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideNetworkService(retrofit: Retrofit): NetworkService {
        return retrofit.create(NetworkService::class.java)
    }

    @Provides
    @Singleton
    fun provideApiService(networkService: NetworkService): PostRepository {
        return PostRepository(networkService)
    }
}