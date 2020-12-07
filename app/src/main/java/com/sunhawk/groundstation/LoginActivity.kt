package com.sunhawk.groundstation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sunhawk.groundstation.databinding.ActivityLoginBinding
import com.sunhawk.groundstation.model.LoginModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView(
                this,
                R.layout.activity_login
            ) as ActivityLoginBinding
        val loginModel = LoginModel(application)
        binding.loginModel = loginModel
        et_name.postDelayed(Runnable {
            runOnUiThread(Runnable {
                loginModel.name.postValue("hahahah")
            })
        }, 2000)

    }


}