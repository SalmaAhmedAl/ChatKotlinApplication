package com.example.chatkotlinapp.base

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.example.chatkotlinapp.R
import com.example.chatkotlinapp.ui.register.Navigator

abstract class BaseActivity<vb:ViewDataBinding, vm : ViewModel> : AppCompatActivity(), BaseNavigator {
    lateinit var viewBinding: vb
    lateinit var viewModel: vm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, getLayoutId())
        viewModel = generateViewModel()
    }

    abstract fun getLayoutId(): Int
    abstract fun generateViewModel(): vm

    var alertDialog: AlertDialog? = null
    var progressDialog: ProgressDialog? = null
    override fun showLoading(message: String) {
        progressDialog = ProgressDialog(this)
        progressDialog?.setMessage(message)
        progressDialog?.show()

    }

    override fun showMessage(message: String) {
        alertDialog = AlertDialog.Builder(this)
            .setMessage(message)
            .setPositiveButton("OK") { dialogInterface, i ->
                dialogInterface.dismiss()

            }.show()

    }

    override fun hideDialogue() {
        progressDialog?.dismiss()
        progressDialog = null
        alertDialog?.dismiss()
        alertDialog = null
    }
}

interface BaseNavigator{
    fun showLoading(message: String)
    fun showMessage(message: String)
    fun hideDialogue()
}

open class BaseViewModel<N:BaseNavigator>:ViewModel(){
    var navigator :N?=null
}

