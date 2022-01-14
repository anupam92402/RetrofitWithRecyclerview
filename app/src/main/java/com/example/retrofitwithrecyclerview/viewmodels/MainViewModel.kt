package com.example.retrofitwithrecyclerview.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitwithrecyclerview.models.Photos
import com.example.retrofitwithrecyclerview.repositories.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository) : ViewModel() {

    val photoList = MutableLiveData<List<Photos>>()

    fun getAllPhotos() {

        val response = repository.getAllPhotos()
        response.enqueue(object : Callback<List<Photos>> {
            override fun onResponse(call: Call<List<Photos>>, response: Response<List<Photos>>) {
                photoList.value = response.body()
            }

            override fun onFailure(call: Call<List<Photos>>, t: Throwable) {

            }
        })
    }
}