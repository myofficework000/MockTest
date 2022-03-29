package com.example.sapinterview.view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sapinterview.data_layer.MockData
import com.example.sapinterview.databinding.ItemViewBinding

class MockAdapter(private val context: Context, private val listOfMockData: List<MockData>) :
    RecyclerView.Adapter<MockViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MockViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemViewBinding.inflate(layoutInflater, parent, false)
        return MockViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MockViewHolder, position: Int) {
        holder.bind(listOfMockData[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailScreenActivity::class.java)
            intent.apply {
                putExtra(NAME, listOfMockData[position].name)
                putExtra(DESCRIPTION, listOfMockData[position].description)
                putExtra(IMAGE, listOfMockData[position].image)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = listOfMockData.size

    companion object {
        const val NAME = "name"
        const val DESCRIPTION = "description"
        const val IMAGE = "image"
    }
}