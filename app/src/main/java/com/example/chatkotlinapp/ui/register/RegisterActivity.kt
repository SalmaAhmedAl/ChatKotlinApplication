package com.example.chatkotlinapp.ui.register

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chatkotlinapp.R
import com.example.chatkotlinapp.base.BaseActivity
import com.example.chatkotlinapp.databinding.ActivityRegisterBinding
import com.example.chatkotlinapp.ui.login.LoginActivity

class RegisterActivity : BaseActivity<ActivityRegisterBinding, RegisterViewModel>(),Navigator{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator =this
        viewBinding.vm=viewModel
    }




    override fun getLayoutId(): Int {
        return R.layout.activity_register
    }

    override fun generateViewModel(): RegisterViewModel {
        return ViewModelProvider(this).get(RegisterViewModel::class.java)
    }

    override fun goHome() {
        val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
    }

    override fun gotoLogin() {
        val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}