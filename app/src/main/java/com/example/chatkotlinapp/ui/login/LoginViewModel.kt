package com.example.chatkotlinapp.ui.login

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    val email = ObservableField<String>()
    val emailError = ObservableField<String?>()
    val password = ObservableField<String>()
    val passwordError = ObservableField<String?>()

    fun login() {
        if (!validateForm()) return
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

}

