package com.example.sapinterview.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sapinterview.databinding.ActivityMainBinding

/*This class is responsible to show all buttons in the corner and their click to open a new screen
of list screen*/

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.apply {
            buttonLeftTop.setOnClickListener {
                callNextScreen()
            }

            buttonRightTop.setOnClickListener {
                callNextScreen()
            }
        }
    }

    /*
    This method will call next screen to show list of data coming from Data layer*/
    private fun callNextScreen() {
        startActivity(Intent(this, ListScreenActivity::class.java))
    }
}