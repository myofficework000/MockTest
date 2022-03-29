package com.example.sapinterview.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sapinterview.data_layer.MockService
import com.example.sapinterview.data_layer.Repository
import com.example.sapinterview.databinding.ActivityListScreenBinding
import com.example.sapinterview.viewmodels.ListViewModel
import com.example.sapinterview.viewmodels.MockViewModelFactory

class ListScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListScreenBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var mockAdapter: MockAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        setupViewModel()
        setUpObserver()
        listViewModel.getMockData()
    }

    private fun initView() {
        binding.recyclerViewMockData.layoutManager = LinearLayoutManager(this@ListScreenActivity)
    }

    private fun setupViewModel() {
        val repository = Repository(MockService.getInstance())
        val factory = MockViewModelFactory(repository)
        listViewModel = ViewModelProvider(this, factory)[ListViewModel::class.java]
    }

    private fun setUpObserver() {
        listViewModel.mockLiveData.observe(this) {
            mockAdapter = MockAdapter(this, it.toMutableList())
            binding.recyclerViewMockData.adapter = mockAdapter
        }

        listViewModel.processing.observe(this) {
            if (it) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        }
    }
}