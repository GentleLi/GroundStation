package com.sunhawk.groundstation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.sunhawk.groundstation.data.LoginModel
import com.sunhawk.groundstation.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    companion object {
        val TAG: String = "LoginActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel =
            ViewModelProvider.AndroidViewModelFactory(application).create(LoginModel::class.java)
        val binding =
            DataBindingUtil.setContentView(
                this,
                R.layout.activity_login
            ) as ActivityLoginBinding

        // Bind layout with ViewModel
        binding.loginModel = viewModel
        // LiveData needs the lifecycle owner
        binding.lifecycleOwner = this
    }

}