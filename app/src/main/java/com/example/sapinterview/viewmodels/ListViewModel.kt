package com.example.sapinterview.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sapinterview.data_layer.MockData
import com.example.sapinterview.data_layer.MockService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListViewModel(private val mockService: MockService) : ViewModel() {

    lateinit var mockLiveData: MutableLiveData<List<MockData>>

    fun getMockData() {
        val call = mockService.getMockData()
        call.enqueue(object : Callback<List<MockData>> {
            override fun onResponse(
                call: Call<List<MockData>>,
                response: Response<List<MockData>>
            ) {
                if (response.isSuccessful) {
                    mockLiveData.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<MockData>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}