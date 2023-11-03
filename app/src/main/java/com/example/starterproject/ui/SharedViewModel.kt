package com.example.starterproject.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {
    val message = MutableLiveData<String>()

    // function to send message
    fun message(text: String) {
        message.value = text
    }
}