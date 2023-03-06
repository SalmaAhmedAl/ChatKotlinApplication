package com.example.chatkotlinapp.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.chatkotlinapp.R
import com.example.chatkotlinapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    lateinit var dataBinding:ActivityRegisterBinding
    lateinit var viewModel :RegisterViewMoel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding= DataBindingUtil.setContentView(this,R.layout.activity_register)
        viewModel=ViewModelProvider(this).get(RegisterViewMoel::class.java)
    }
}