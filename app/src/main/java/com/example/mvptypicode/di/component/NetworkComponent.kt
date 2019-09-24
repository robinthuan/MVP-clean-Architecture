package com.example.mvptypicode.di.component

import com.example.mvptypicode.BaseFragment
import com.example.mvptypicode.di.module.NetworkModule
import com.example.mvptypicode.presentation.home.HomeActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface NetworkComponent {
    fun inject(homeActivity: HomeActivity)
    fun inject(fragmentPost: BaseFragment)
}