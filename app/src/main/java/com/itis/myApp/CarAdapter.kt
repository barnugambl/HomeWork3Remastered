package com.itis.myApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.itis.myApp.databinding.ItemFruitBinding

class CarAdapter(
    private var list: List<Car>,
    private val glide: RequestManager,
    private val onItemClick: (Car) -> Unit,
) : RecyclerView.Adapter<CarItem>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            CarItem = CarItem(
            ItemFruitBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        glide = glide,
        onItemClick = onItemClick,
        )

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CarItem, position: Int) {
        holder.onBind(list[position])
    }

    fun updateDataset(newList: List<Car>) {
        list = newList
        notifyDataSetChanged()
    }
}
