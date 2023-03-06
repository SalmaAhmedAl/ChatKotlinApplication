package com.example.chatkotlinapp.ui.register

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class RegisterViewModel:ViewModel() {
    val userName = ObservableField<String>()
    val userNameError = ObservableField<String?>()
    val email = ObservableField<String>()
    val emailError = ObservableField<String?>()
    val password = ObservableField<String>()
    val passwordError = ObservableField<String?>()
    val passwordConfirmation = ObservableField<String>()
    val passwordConfirmationError = ObservableField<String?>()
    fun register(){
    if(!validateForm())return
    }
  var isValid=true
    fun validateForm():Boolean{
        isValid=true
        if(userName.get().isNullOrBlank()){
            //show error
            userNameError.set("Please enter your name")
            isValid=false
        }else{
            //hide error
            userNameError.set(null)
            isValid=true

        }

        if(email.get().isNullOrBlank()){
            //show error
            emailError.set("Please enter your email")
            isValid=false
        }else{
            //hide error
            emailError.set(null)
            isValid=true

        }

        if(password.get().isNullOrBlank()){
            //show error
            passwordError.set("Please enter your password")
            isValid=false
        }else{
            //hide error
            passwordError.set(null)
            isValid=true

        }

        if(passwordConfirmation.get().isNullOrBlank()){
            //show error
            passwordConfirmationError.set("Please re-enter your password")
            isValid=false
        }else if(password.get()?.equals(passwordConfirmation.get())==false){
            passwordConfirmationError.set("Password doesn't match")
        } else{
            //hide error
            passwordConfirmationError.set(null)
            isValid=true

        }

    return true
    }
}