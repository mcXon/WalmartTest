package com.example.walmarttest.model

import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getProducts(): Flow<UIState>
}