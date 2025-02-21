package com.example.recyclerview_demo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_demo.databinding.ItemLayoutBinding

class MyAdapter(private val itemList:List<ModelClass>):RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemLayoutBinding):RecyclerView.ViewHolder(binding.root){
        fun onBind(item:ModelClass){
            binding.textView.text = item.feature
            binding.toggleButton.isChecked = item.isToggled

            binding.toggleButton.setOnCheckedChangeListener { _,isChecked ->
                item.isToggled = isChecked
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(itemList[position])
    }
}