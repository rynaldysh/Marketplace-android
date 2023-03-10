package com.example.marketplace.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.marketplace.core.data.repository.AppRepository
import com.example.marketplace.core.data.source.remote.request.LoginRequest

class LoginViewModel (val repo : AppRepository) : ViewModel(){

    private val _text = MutableLiveData<String>().apply {
        value = "a@gmail.com"
    }
    val text: LiveData<String> = _text

    private val _textt = MutableLiveData<String>().apply {
        value = "123456789"
    }
    val textt: LiveData<String> = _textt

    fun ubahData(){
        _text.postValue("coba aja dulu")
    }

    fun login(data: LoginRequest) = repo.login(data).asLiveData()
}
