package com.example.myapplication.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.example.myapplication.R
import com.example.myapplication.data.model.PersonModel
import com.example.myapplication.presentation.presenter.PersonViewModel
import com.example.myapplication.util.UiUtil
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment(), View.OnClickListener {
    private lateinit var personModel: PersonModel
    private lateinit var personViewModel: PersonViewModel
    private lateinit var navigationController: NavController
    private var uiUtil = UiUtil()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        uiUtil.showBackButton(this)
        personViewModel =
            ViewModelProviders.of(requireActivity()).get(PersonViewModel()::class.java)
        personViewModel.contextLiveData.value = requireActivity()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigationController = Navigation.findNavController(view)

        arguments?.get("person")?.let {
            personModel = it as PersonModel
            edt_person_name.setText(personModel.name)
        }

        btn_save.setOnClickListener(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        navigationController.navigate(
            R.id.action_detailFragment_to_mainFragment,
            null,
            NavOptions.Builder().setPopUpTo(R.id.mainFragment, true)
                .build()
        )
        return true
    }

    override fun onClick(view: View?) {
        uiUtil.hideKeyboard(this)

        when (view) {
            btn_save -> {
                if (::personModel.isInitialized) {
                    personModel.name = edt_person_name.text.toString()
                    personViewModel.updatePerson(personModel)
                } else {
                    personModel = PersonModel(null, edt_person_name.text.toString())
                    personViewModel.savePerson(personModel)
                }
            }
        }
    }
}