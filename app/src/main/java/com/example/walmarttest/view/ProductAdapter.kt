package com.example.walmarttest.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.walmarttest.databinding.ProductItemLayoutBinding
import com.example.walmarttest.model.ProductItems

class ProductAdapter(private var dataSet: List<ProductItems>): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(private val binding: ProductItemLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun onBind(productItem: ProductItems){
            binding.productName.text = productItem.productName
            binding.productDescription.text = productItem.longDescription
        }
    }

    fun updateDataSet(newDataSet: List<ProductItems>){
        dataSet = newDataSet
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ProductViewHolder(
            ProductItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.onBind(
            dataSet[position]
        )
    }

    override fun getItemCount() = dataSet.size
}