package com.example.walmarttest.model

import com.example.walmarttest.model.remote.ProductApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RepositoryImpl: Repository {

    override fun getProducts(): Flow<UIState> {
        return flow {
            emit(UIState.LOADING())

            val response = ProductApi.api.getProducts()

            if (response.isSuccessful){
                response.body()?.let {
                    emit(UIState.RESPONSE(it.products))
                    delay(500)
                    emit(UIState.LOADING(false))
                } ?: kotlin.run {
                    emit(UIState.ERROR("Empty body"))
                    delay(500)
                    emit(UIState.LOADING(false))
                }
            }else {
                emit(UIState.ERROR("Server error code: ${response.code()}"))
                delay(500)
                emit(UIState.LOADING(false))
            }
        }
    }
}