package com.sunhawk.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sunhawk.myapplication.api.ApiTransformer
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Example of a call to a native method
        sample_text.text = stringFromJNI()
        btn_launch.setOnClickListener {
            onTestLaunch();
        }
        btn_block.setOnClickListener {
            onTestBlocking()
        }
    }

    private fun onTestBlocking() {
        CoroutineScope(Dispatchers.IO).launch { // 在后台启动一个新的协程并继续
            val userProfile = ApiTransformer.getUserProfile("GentleLi")
            print(userProfile.bio)
        }
        println("Hello,")
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
