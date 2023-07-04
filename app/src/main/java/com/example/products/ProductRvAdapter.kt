package com.example.products

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.products.databinding.ProductsListBinding

class ProductRvAdapter(var product: List<Product>):RecyclerView.Adapter<ProductRvAdapter.ProductsViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductRvAdapter.ProductsViewHolder {
        val binding=ProductsListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductRvAdapter.ProductsViewHolder, position: Int) {
        val currentProduct=product.get(position)
        val binding=holder.binding
        binding.tvbrand.text=currentProduct.brand
        binding.tvcategory.text=currentProduct.category
        binding.tvid.text=currentProduct.id.toString()
        binding.tvprice.text=currentProduct.price.toString()
        binding.tvdescription.text=currentProduct.description
        binding.tvratings.text=currentProduct.ratings.toString()
        binding.tvstock.text=currentProduct.stock.toString()
        binding.tvthumbnail.text=currentProduct.thumbnail
        binding.tvtitle.text=currentProduct.title

    }

    override fun getItemCount(): Int {
        return product.size
    }

    class ProductsViewHolder(var binding: ProductsListBinding):RecyclerView.ViewHolder(binding.root)
}
