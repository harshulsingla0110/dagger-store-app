package com.harshul.storeapp.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.harshul.storeapp.FakerApplication
import com.harshul.storeapp.databinding.ActivityMainBinding
import com.harshul.storeapp.ui.adapter.StoreAdapter
import com.harshul.storeapp.ui.viewmodel.MainViewModel
import com.harshul.storeapp.ui.viewmodel.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as FakerApplication).applicationComponent.inject(this)

        mainViewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]
        mainViewModel.productsLiveData.observe(this, Observer {
            val storeListAdapter = StoreAdapter(it)
            binding.recyclerView.apply {
                adapter = storeListAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        })


    }


}