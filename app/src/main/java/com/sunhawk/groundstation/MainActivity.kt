package com.sunhawk.groundstation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sunhawk.groundstation.api.ApiTransformer
import com.sunhawk.groundstation.observer.MainObserver
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_launch.setOnClickListener {
            onTestLaunch();
        }
        btn_block.setOnClickListener {
            onTestBlocking()
        }
        btn_login_activity.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        lifecycle.addObserver(MainObserver())


    }

    private fun onTestBlocking() {
        CoroutineScope(Dispatchers.IO).launch { // 在后台启动一个新的协程并继续
            val userProfile = ApiTransformer.getUserProfile("GentleLi")
            print(userProfile.bio)
            runOnUiThread {
                val text = userProfile.login + "\n" + userProfile.bio
                tv_response.text = text
            }
        }
    }

    private fun onTestLaunch() {
        GlobalScope.launch {
            delay(1000L)
            println("World !")
        }
        println("Hello,") // 协程已在等待时主线程还在继续
        Thread.sleep(2000L) // 阻塞主线程 2 秒钟来保证 JVM 存活
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
