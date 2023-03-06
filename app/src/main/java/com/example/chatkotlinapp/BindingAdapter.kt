package com.example.chatkotlinapp

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("error")
fun bindErrorMessageInTextInputLayout(textInputLayout: TextInputLayout, errorMessage:String?){
    textInputLayout.error= errorMessage
}

@BindingAdapter("errorId")
fun bindErrorMessageInTextInputLayout(textInputLayout: TextInputLayout, stringId:Int?){
    if (stringId==null){
        textInputLayout.error=null
        return
    }
    textInputLayout.error= textInputLayout.context.getString(stringId)
}