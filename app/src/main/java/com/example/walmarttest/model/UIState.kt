package com.example.walmarttest.model

sealed class UIState{
    data class RESPONSE(val products: List<ProductItems>): UIState()
    data class ERROR(val errorResponse: String): UIState()
    data class LOADING(val isLoading: Boolean = true): UIState()
}
