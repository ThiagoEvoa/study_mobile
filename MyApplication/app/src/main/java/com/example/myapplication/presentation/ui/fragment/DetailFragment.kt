package com.example.myapplication.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.example.myapplication.R
import com.example.myapplication.data.model.PersonModel
import com.example.myapplication.presentation.presenter.PersonViewModel
import com.example.myapplication.presentation.ui.activity.MainActivity
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment(), View.OnClickListener{
    lateinit var personModel: PersonModel
    private lateinit var personViewModel: PersonViewModel
    private lateinit var navigationController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        personViewModel =
            ViewModelProviders.of(requireActivity()).get(PersonViewModel()::class.java)
        personViewModel.contextLiveData.value = requireActivity()
        (requireActivity() as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setHasOptionsMenu(true)
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
        val navOptions: NavOptions = NavOptions.Builder().setPopUpTo(R.id.action_detailFragment_to_mainFragment, true).build()
        navigationController.navigate(R.id.action_detailFragment_to_mainFragment, null, navOptions)
        return true
    }

    override fun onClick(view: View?) {
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