package com.example.myapplication.util

import android.app.Activity
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
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

    fun showBackButton(fragment: Fragment){
        (fragment.requireActivity() as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        fragment.setHasOptionsMenu(true)
    }

    fun hideBackButton(fragment: Fragment){
        (fragment.requireActivity() as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        fragment.setHasOptionsMenu(false)
    }

    fun hideKeyboard(fragment: Fragment){
        val keyBoard: InputMethodManager = fragment.requireContext().getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        keyBoard.hideSoftInputFromWindow(fragment.requireActivity().currentFocus?.windowToken, 0)
    }
}