package com.example.sapinterview.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.sapinterview.R
import com.example.sapinterview.databinding.ActivityDetailScreenBinding
import com.example.sapinterview.view.MockListAdapter.Companion.DESCRIPTION
import com.example.sapinterview.view.MockListAdapter.Companion.IMAGE
import com.example.sapinterview.view.MockListAdapter.Companion.NAME

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
            Glide.with(this@DetailScreenActivity)
                .load(intent.getStringExtra(IMAGE))
                .error(R.drawable.ic_launcher_foreground)
                .into(imageviewMock)
        }
    }
}