package com.example.sapinterview.data_layer

class Repository(private val mockService: MockService) {

    fun getMockData() = mockService.getMockData()
}