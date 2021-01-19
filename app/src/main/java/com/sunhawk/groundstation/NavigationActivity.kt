package com.sunhawk.groundstation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sunhawk.groundstation.databinding.ActivityNavigationBinding

class NavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_navigation
        ) as ActivityNavigationBinding
        binding.lifecycleOwner = this

    }

}