package com.example.walmarttest.di

import com.example.walmarttest.model.Repository
import com.example.walmarttest.model.RepositoryImpl

object Provider {

    fun provideRepository(): Repository = RepositoryImpl()
}