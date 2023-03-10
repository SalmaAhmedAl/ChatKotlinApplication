package com.example.chatkotlinapp.ui.login

import androidx.databinding.ObservableField
import com.example.chatkotlinapp.base.BaseNavigator
import com.example.chatkotlinapp.base.BaseViewModel
import com.google.firebase.auth.FirebaseAuth


class LoginViewModel : BaseViewModel<NavigatorLogin>() {

    val email = ObservableField<String>()
    val emailError = ObservableField<String?>()
    val password = ObservableField<String>()
    val passwordError = ObservableField<String?>()
    val auth =FirebaseAuth.getInstance()

    fun login() {
        if (!validateForm()) return
        navigator?.showLoading("Loading...")
        auth.signInWithEmailAndPassword(
            email.get()!!,
            password.get()!!
        ).addOnCompleteListener{task->
            if(task.isSuccessful){
                navigator?.showMessage(task.result.user?.uid?:"")
            }else{
                navigator?.showMessage(task.exception?.localizedMessage?:"")
            }

        }
    }

    var isValid = true
    fun validateForm(): Boolean {
        isValid = true

        if (email.get().isNullOrBlank()) {
            //show error
            emailError.set("Please enter your email")
            isValid = false
        } else {
            //hide error
            emailError.set(null)
            isValid = true

        }

        if (password.get().isNullOrBlank()) {
            //show error
            passwordError.set("Please enter your password")
            isValid = false
        } else {
            //hide error
            passwordError.set(null)
            isValid = true

        }



        return true
    }

    fun gotoRegister(){
        navigator?.gotoRegister()
    }

}

