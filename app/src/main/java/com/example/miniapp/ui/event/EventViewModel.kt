package com.example.miniapp.ui.event

import androidx.lifecycle.*

class EventViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "EVENT"
    }
    val text: LiveData<String> = _text
}