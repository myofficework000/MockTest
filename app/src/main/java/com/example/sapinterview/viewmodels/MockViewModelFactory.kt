package com.example.sapinterview.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sapinterview.data_layer.Repository

class MockViewModelFactory(private val repository: Repository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ListViewModel(repository) as T
    }
}