package com.sunhawk.groundstation.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class LoginModel(application: Application) : AndroidViewModel(application) {

    var name = MutableLiveData<String>()
    var pwd = MutableLiveData<String>()


}