package com.itis.myApp

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.itis.myApp.databinding.ItemFruitBinding

class CarItem(
    private val binding: ItemFruitBinding,
    private val glide: RequestManager,
    private val onItemClick: (Car) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    private val options: RequestOptions = RequestOptions
        .diskCacheStrategyOf(DiskCacheStrategy.NONE)

    fun onBind(car: Car) {
        binding.run {
            tvTitle.text = car.brand
            tvDesc.text = car.description

            glide
                .load(car.url)
                .placeholder(R.drawable.loading)
                .error(R.drawable.error)
                .apply(options)
                .into(ivImage)

            root.setOnClickListener {
                onItemClick(car)
            }
        }
    }
}