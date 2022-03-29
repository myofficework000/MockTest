package com.example.sapinterview.data_layer

import com.example.sapinterview.data_layer.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    lateinit var retrofit: Retrofit

    fun getRetrofitClient(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}