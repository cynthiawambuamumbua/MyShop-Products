package com.example.products.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.products.databinding.ProductsListBinding
import com.example.products.model.Comments
import com.example.products.model.Product
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class ProductRvAdapter(var product: List<Product>):RecyclerView.Adapter<ProductRvAdapter.ProductsViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductsViewHolder {
        val binding=ProductsListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
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
        Picasso
            .get().load(currentProduct.thumbnail)
            .resize(80, 80)
            .centerInside()
            .transform(CropCircleTransformation())
            .into(binding.ivImage)

    }
    override fun getItemCount(): Int {
        return product.size
    }

    class ProductsViewHolder(var binding: ProductsListBinding):RecyclerView.ViewHolder(binding.root)
}
