package com.example.chatkotlinapp.ui.register

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.chatkotlinapp.R
import com.example.chatkotlinapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() , Navigator{
    lateinit var dataBinding:ActivityRegisterBinding
    lateinit var viewModel :RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding= DataBindingUtil.setContentView(this,R.layout.activity_register)
        viewModel=ViewModelProvider(this).get(RegisterViewModel::class.java)
        dataBinding.vm=viewModel  //Now I send my view model to xml

        viewModel.navigator =this

    }
     var alertDialog:AlertDialog ?=null
     var progressDialog:ProgressDialog ?=null
    override fun showLoading(message: String) {
       progressDialog= ProgressDialog(this)
        progressDialog?.setMessage(message)
        progressDialog?.show()

    }

    override fun showMessage(message: String) {
       alertDialog = AlertDialog.Builder(this)
           .setMessage(message)
           .setPositiveButton("OK"){ dialogInterface, i->
               dialogInterface.dismiss()

           }.show()

    }

    override fun hideDialogue() {
        progressDialog?.dismiss()
        progressDialog = null
        alertDialog?.dismiss()
        alertDialog=null
    }
}