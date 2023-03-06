package com.example.chatkotlinapp.ui.register

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class RegisterViewModel:ViewModel() {
    val userName = ObservableField<String>()
    val userNameError = ObservableField<String?>()
    val email = ObservableField<String>()
    val emailError = ObservableField<String?>()
    val password = ObservableField<String>()
    val passwordError = ObservableField<String?>()
    val passwordConfirmation = ObservableField<String>()
    val passwordConfirmationError = ObservableField<String?>()

    val auth= FirebaseAuth.getInstance()
    var navigator:Navigator ?=null
    fun register() {
        if (!validateForm()) return
        navigator?.showLoading("Loading...")
        auth.createUserWithEmailAndPassword(
            email.get()!!, password.get()!!
        )
            .addOnCompleteListener { task ->
                navigator?.hideDialogue()
                if (task.isSuccessful) {
                    navigator?.showMessage("Successful registration")
                    //Log.e("userId",task.result.user?.uid?:"")
                }else{
                   // Log.e("error",task.exception?.localizedMessage?:"")
                    navigator?.showMessage(task.exception?.localizedMessage?:"")
                }
            }
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