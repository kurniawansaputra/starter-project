package com.example.starterproject.ui.activity.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.starterproject.adapter.UserAdapter
import com.example.starterproject.data.Result
import com.example.starterproject.databinding.ActivityMainBinding
import com.example.starterproject.util.setLoading
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        swipeRefresh()
        getUsers()
    }

    private fun getUsers() {
        mainViewModel.getUsers().observe(this) {
            if (it != null) {
                when (it) {
                    is Result.Loading -> {
                        setLoading(this, true)
                        setRefresh(false)
                    }
                    is Result.Success -> {
                        setLoading(this, false)
                        setRefresh(false)
                        val storyAdapter = UserAdapter(it.data.data, this)
                            binding.rvUser.adapter = storyAdapter
                            binding.rvUser.setHasFixedSize(true)
                    }
                    is Result.Error -> {
                        setRefresh(false)
                        setLoading(this, false)
                        Toast.makeText(this@MainActivity, it.error, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun setRefresh(isRefresh: Boolean) {
        binding.swipeRefresh.isRefreshing = isRefresh
    }

    private fun swipeRefresh() {
        binding.swipeRefresh.setOnRefreshListener {
            getUsers()
        }
    }
}