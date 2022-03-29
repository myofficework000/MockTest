package com.example.sapinterview.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sapinterview.R
import com.example.sapinterview.databinding.ActivityDetailScreenBinding
import com.example.sapinterview.view.MockAdapter.Companion.DESCRIPTION
import com.example.sapinterview.view.MockAdapter.Companion.IMAGE
import com.example.sapinterview.view.MockAdapter.Companion.NAME
import com.squareup.picasso.Picasso

class DetailScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.apply {
            labelName.text = intent.getStringExtra(NAME) ?: "Dummy"
            labelDescription.text = intent.getStringExtra(DESCRIPTION) ?: "Dummy"
            Picasso.get()
                .load(intent.getStringExtra(IMAGE))
                .error(R.drawable.ic_launcher_foreground)
                .into(imageviewMock)
        }
    }
}