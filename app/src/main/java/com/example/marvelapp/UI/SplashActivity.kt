package com.example.marvelapp.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.marvelapp.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            callActivityLogin()
            finish()
        }, 1000)
    }

    private fun callActivityLogin(){
        startActivity(Intent(this, LoginActivity::class.java))
    }
}