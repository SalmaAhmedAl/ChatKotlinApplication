package com.example.chatkotlinapp.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.chatkotlinapp.R
import com.example.chatkotlinapp.base.BaseActivity
import com.example.chatkotlinapp.databinding.ActivityLoginBinding
import com.example.chatkotlinapp.ui.register.Navigator
import com.example.chatkotlinapp.ui.register.RegisterActivity


class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() ,
    NavigatorLogin {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          //0Now I send my view model to xml

        viewBinding.vm=viewModel
        viewModel.navigator=this


        viewBinding.content.createAccountBtn.setOnClickListener{
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun generateViewModel(): LoginViewModel {
        return ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun gotoRegister() {
        val intent =Intent(this@LoginActivity, RegisterActivity::class.java)
        startActivity(intent)
        finish()
    }
}