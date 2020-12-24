package com.example.triviaapp.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.triviaapp.R
import java.lang.Exception

class SplashActivity : AppCompatActivity() {

    var delayRun=1000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        try {
            var handler = Handler()
            var run=Runnable{
                startActivity(Intent(this, MainActivity :: class.java))
                finish()
            }
            handler.postDelayed(run,delayRun)
        }
        catch (e:Exception){
            e.printStackTrace()
        }

    }
}