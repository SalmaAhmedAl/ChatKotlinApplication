package com.example.chatkotlinapp.ui.register

import android.os.Message

interface Navigator {

    fun showLoading(message: String)
    fun showMessage(message: String)
    fun hideDialogue()
}