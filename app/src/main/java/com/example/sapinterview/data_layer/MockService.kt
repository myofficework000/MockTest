package com.example.sapinterview.data_layer

import com.example.sapinterview.data_layer.Constants.API_KEY
import retrofit2.Call
import retrofit2.http.GET

interface MockService {

    @GET(API_KEY)
    fun getMockData(): Call<List<MockData>>

    companion object {
        fun getInstance(): MockService =
            RetrofitClient.retrofit.create(MockService::class.java)
    }
}