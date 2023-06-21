package com.example.starterproject.ui.activity.main

import androidx.lifecycle.ViewModel
import com.example.starterproject.data.repository.MainRepository

class MainViewModel(private val mainRepository: MainRepository): ViewModel() {
    fun getUsers() = mainRepository.getUsers()
}