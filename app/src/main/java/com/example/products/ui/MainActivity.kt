package com.example.products.ui
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.products.databinding.ActivityMainBinding
import com.example.products.viewModel.ProductsViewModel

class MainActivity : AppCompatActivity() {
    val productsViewModel: ProductsViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


    override fun onResume() {
        super.onResume()
        productsViewModel.fetchProducts()

        productsViewModel.productsLiveData.observe(this) { productsList ->
            Toast.makeText(baseContext, "fetched ${productsList?.size} products", Toast.LENGTH_LONG)
                .show()
            binding.rvProducts.layoutManager=LinearLayoutManager(this)
            binding.rvProducts.adapter=ProductRvAdapter(productsList)
        }
        productsViewModel.errorLiveData.observe(this) { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        }


    }
}