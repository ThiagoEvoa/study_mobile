package com.example.myapplication.util

import android.view.WindowManager
import androidx.fragment.app.FragmentActivity
import com.example.myapplication.presentation.ui.activity.MainActivity

class UiUtil {
    fun setFullScreen(fragmentActivity: FragmentActivity){
        fragmentActivity.window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }

    fun removeFullScreen(fragmentActivity: FragmentActivity){
        fragmentActivity.window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }

    fun showActionBar(fragmentActivity: FragmentActivity){
        (fragmentActivity as MainActivity).supportActionBar?.show()
    }

    fun hideActionBar(fragmentActivity: FragmentActivity){
        (fragmentActivity as MainActivity).supportActionBar?.hide()
    }
}