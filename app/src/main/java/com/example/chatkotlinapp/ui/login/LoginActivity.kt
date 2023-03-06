package com.example.chatkotlinapp.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.chatkotlinapp.R
import com.example.chatkotlinapp.databinding.ActivityLoginBinding
import com.example.chatkotlinapp.ui.register.RegisterActivity

class LoginActivity : AppCompatActivity() {
    lateinit var dataBinding:ActivityLoginBinding
    lateinit var viewModel :LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding= DataBindingUtil.setContentView(this,R.layout.activity_login)
        viewModel=ViewModelProvider(this).get(LoginViewModel::class.java)
        dataBinding.vm=viewModel  //Now I send my view model to xml

        dataBinding.content.createAccountBtn.setOnClickListener{
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }

    }
}