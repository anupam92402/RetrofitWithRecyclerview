package com.example.retrofitwithrecyclerview.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitwithrecyclerview.adapters.MainAdapter
import com.example.retrofitwithrecyclerview.databinding.ActivityMainBinding
import com.example.retrofitwithrecyclerview.remote.RetrofitService
import com.example.retrofitwithrecyclerview.repositories.MainRepository
import com.example.retrofitwithrecyclerview.viewmodels.MainViewModel
import com.example.retrofitwithrecyclerview.viewmodels.factory.MyViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding//view binding
    lateinit var viewModel: MainViewModel//view model
    private val retrofitService = RetrofitService.getInstance()//retrofit
    private lateinit var mAdapter: MainAdapter//adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAdapter = MainAdapter()

        viewModel =
            ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(
                MainViewModel::class.java
            )

        binding.recyclerView.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        viewModel.photoList.observe(this, Observer {
            mAdapter.setMovieList(it)
        })

        viewModel.getAllPhotos()
    }
}