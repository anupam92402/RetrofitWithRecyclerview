package com.example.retrofitwithrecyclerview.repositories

import com.example.retrofitwithrecyclerview.remote.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllPhotos() = retrofitService.getAllPhotos()

}