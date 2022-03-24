package com.example.walmarttest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.walmarttest.di.Provider
import com.example.walmarttest.model.Repository
import com.example.walmarttest.model.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ProductsViewModel: ViewModel() {

    val _position = MutableStateFlow<Int>(0)

    private val repository: Repository by lazy {
        Provider.provideRepository()
    }
    private val _products = MutableLiveData<UIState>()
    val products: LiveData<UIState>
    get() = _products

    init {
        viewModelScope.launch {
            repository.getProducts().collect{uiState->
                _products.postValue(
                    uiState
                )
            }
        }
    }
}