package com.example.products.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.products.model.Product
import com.example.products.repository.ProductsRepository
import kotlinx.coroutines.launch

class ProductsViewModel:ViewModel() {
    val productsRepository=ProductsRepository()
    val productsLiveData=MutableLiveData<List<Product>>()
    val errorLiveData=MutableLiveData<String>()

    fun fetchProducts(){
        viewModelScope.launch {
            val response=productsRepository.getProducts()
            if (response.isSuccessful){
                productsLiveData.postValue(response.body()?.products)
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}