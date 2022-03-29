package com.example.sapinterview.view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sapinterview.R
import com.example.sapinterview.data_layer.Constants.BASE_URL
import com.example.sapinterview.data_layer.MockData

class MockListAdapter(
    private val context: Context,
    private val listOfMockData: MutableList<MockData>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return listOfMockData.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return null!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.apply {
            val textName = itemView.findViewById<TextView>(R.id.label_name)
            val textDescription = itemView.findViewById<TextView>(R.id.label_description)
            val image = itemView.findViewById<ImageView>(R.id.imageview_mock)

            textName.text = listOfMockData[position].name
            textDescription.text = listOfMockData[position].description
            Glide.with(context)
                .load(listOfMockData[position].image)
                .error(R.drawable.ic_launcher_foreground)
                .into(image)
        }

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

    companion object {
        const val NAME = "name"
        const val DESCRIPTION = "description"
        const val IMAGE = "image"
    }
}