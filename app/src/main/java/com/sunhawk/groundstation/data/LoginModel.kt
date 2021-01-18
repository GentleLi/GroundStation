package com.sunhawk.groundstation.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginModel : ViewModel() {

    private val _name = MutableLiveData<String>("Jack")
    private val _age = MutableLiveData<Int>()

    val name: LiveData<String> = _name
    val age: LiveData<Int> = _age

    fun addAge() {
        _age.value = (_age.value ?: 0) + 1
    }
}