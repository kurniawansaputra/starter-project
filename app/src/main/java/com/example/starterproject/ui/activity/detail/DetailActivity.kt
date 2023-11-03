package com.example.starterproject.ui.activity.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.starterproject.databinding.ActivityDetailBinding
import com.example.starterproject.ui.SharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {
    private var name: String? = null
    private val sharedViewModel: SharedViewModel by viewModel()

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        getDetail()
        setToolbar()
    }

    private fun getDetail() {
        name = intent.getStringExtra("name")

        sharedViewModel.message(name.toString())
    }

    private fun setToolbar() {
        binding.apply {
            toolbar.title = "Detail $name"
        }
    }
}