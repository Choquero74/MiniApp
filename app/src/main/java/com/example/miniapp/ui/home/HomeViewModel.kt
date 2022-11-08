package com.example.miniapp.ui.home

import androidx.lifecycle.*

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "HOME"
    }
    val text: LiveData<String> = _text
}