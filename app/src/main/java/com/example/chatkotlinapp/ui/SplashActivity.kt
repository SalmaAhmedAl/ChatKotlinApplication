package com.example.chatkotlinapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chatkotlinapp.databinding.ActivitySplashBinding
import com.example.chatkotlinapp.ui.registration.RegistrationActivity

class SplashActivity : AppCompatActivity() {
    lateinit var viewBinding : ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        with(viewBinding.logo) {
            alpha=0f
            animate().setDuration(1500).alpha(1f).withEndAction{
                    val intent = Intent(this@SplashActivity, RegistrationActivity::class.java)
                    startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)

            }
        }

    }
}