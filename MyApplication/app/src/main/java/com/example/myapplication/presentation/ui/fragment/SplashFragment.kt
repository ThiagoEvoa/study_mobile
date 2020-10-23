package com.example.myapplication.presentation.ui.fragment

import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.example.myapplication.R
import com.example.myapplication.util.UiUtil

class SplashFragment : Fragment() {
    private val uiUtil = UiUtil()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        uiUtil.setFullScreen(requireActivity())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_splash, container, false)

        uiUtil.hideActionBar(requireActivity())

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navigationController = Navigation.findNavController(view)

        Handler().postDelayed({
            navigationController.navigate(
                R.id.action_splashFragment_to_mainFragment,
                null,
                NavOptions.Builder().setPopUpTo(R.id.splashFragment, true).build()
            )
            uiUtil.removeFullScreen(requireActivity())
            uiUtil.showActionBar(requireActivity())
        }, 3000)
    }
}