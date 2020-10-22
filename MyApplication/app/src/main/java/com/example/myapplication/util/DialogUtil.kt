package com.example.myapplication.util

import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentActivity

class DialogUtil {
    private lateinit var alertDialog: AlertDialog

    fun show(context: FragmentActivity, title: String, message: String) {
        val alertDialogBuilder = AlertDialog.Builder(context)

        alertDialogBuilder.setPositiveButton("Ok", null)

        alertDialog = alertDialogBuilder.create()
        alertDialog.setTitle(title)
        alertDialog.setMessage(message)
        alertDialog.show()
    }

    fun dismissDialog() {
        if (this::alertDialog.isInitialized) {
            alertDialog.dismiss()
        }
    }
}