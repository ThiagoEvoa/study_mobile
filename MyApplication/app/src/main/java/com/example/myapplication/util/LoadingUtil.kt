package com.example.myapplication.util

import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentActivity
import com.example.myapplication.R

class LoadingUtil {
    private lateinit var alertDialog: AlertDialog

    fun show(context: FragmentActivity) {
        val alertDialogBuilder = AlertDialog.Builder(context)
        alertDialogBuilder.setCancelable(false)

        val progressBar = ProgressBar(context)
        alertDialogBuilder.setView(progressBar)

        alertDialog = alertDialogBuilder.create()
        alertDialog.window?.setBackgroundDrawableResource(R.drawable.background_transparent)
        alertDialog.show()
    }

    fun dismissDialog() {
        if (this::alertDialog.isInitialized) {
            alertDialog.dismiss()
        }
    }
}