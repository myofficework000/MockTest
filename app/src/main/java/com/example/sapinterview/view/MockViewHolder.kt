package com.example.sapinterview.view

import androidx.recyclerview.widget.RecyclerView
import com.example.sapinterview.R
import com.example.sapinterview.data_layer.MockData
import com.example.sapinterview.databinding.ItemViewBinding
import com.squareup.picasso.Picasso

class MockViewHolder(val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(mockData: MockData) {
        binding.apply {
            labelName.text = mockData.name
            labelDescription.text = mockData.description
            Picasso.get()
                .load(mockData.image)
                .error(R.drawable.ic_launcher_foreground)
                .into(imageviewMock)
        }
    }
}