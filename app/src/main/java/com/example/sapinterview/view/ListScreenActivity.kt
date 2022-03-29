package com.example.sapinterview.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sapinterview.databinding.ActivityListScreenBinding
import com.example.sapinterview.viewmodels.ListViewModel

class ListScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListScreenBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var mockListAdapter: MockListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        setUpObserver()
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
    }

    private fun initView() {
        binding.apply {
            recyclerViewMockData.layoutManager = LinearLayoutManager(this@ListScreenActivity)
            recyclerViewMockData.adapter = mockListAdapter
        }
    }

    private fun setUpObserver() {
        listViewModel.mockLiveData.observe(this) {
            mockListAdapter = MockListAdapter(this, it.toMutableList())
        }
    }
}