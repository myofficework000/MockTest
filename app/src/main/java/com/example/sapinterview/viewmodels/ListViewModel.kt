package com.example.sapinterview.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sapinterview.data_layer.MockData
import com.example.sapinterview.data_layer.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListViewModel(private val repository: Repository) : ViewModel() {

    val mockLiveData = MutableLiveData<List<MockData>>()
    val processing = MutableLiveData<Boolean>()

    fun getMockData() {
        processing.postValue(true)
        val call = repository.getMockData()
        call.enqueue(object : Callback<List<MockData>> {
            override fun onResponse(
                call: Call<List<MockData>>,
                response: Response<List<MockData>>
            ) {
                if (response.isSuccessful) {
                    mockLiveData.postValue(response.body())
                    processing.postValue(false)
                }
            }

            override fun onFailure(call: Call<List<MockData>>, t: Throwable) {
                t.printStackTrace()
                processing.postValue(false)
            }
        })
    }
}