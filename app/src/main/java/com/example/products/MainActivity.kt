package com.example.products

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.products.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
    override fun onResume() {
        super.onResume()
        fetchProducts()
    }

    fun fetchProducts() {
        val apiClient = ApiClients.buildClients(ApiInterface::class.java)
        val request = apiClient.getProducts()
        request.enqueue(object : Callback<ProductsResponse> {
            override fun onResponse(
                call: Call<ProductsResponse>,
                response: Response<ProductsResponse>
            ) {
                if (response.isSuccessful) {
                    val product= response.body()?.products
                    Toast.makeText(
                        baseContext,
                        "fetched ${product?.size} products",
                        Toast.LENGTH_LONG
                    ).show()
                    binding.rvProducts.layoutManager=LinearLayoutManager(this@MainActivity)
                    binding.rvProducts.adapter= product?.let { ProductRvAdapter(it) }
//                    binding.rvProducts.adapter=ProductRvAdapter(product)

                } else {
                    val error = response.errorBody()?.string()
                    Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ProductsResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })

    }
}