package com.yourssu.restful_api1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yourssu.restful_api1.databinding.ItemBinding
import kotlin.collections.ArrayList

class MainRvAdapter(var centersList: ArrayList<CentersData>) :
    RecyclerView.Adapter<MainRvAdapter.Holder>() {
    inner class Holder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind (centersData: CentersData) {
            binding.user = centersData
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return centersList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(centersList[position])
    }
}