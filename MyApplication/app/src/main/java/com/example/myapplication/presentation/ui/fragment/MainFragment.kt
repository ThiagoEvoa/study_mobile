package com.example.myapplication.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.data.model.PersonModel
import com.example.myapplication.presentation.presenter.PersonViewModel
import com.example.myapplication.presentation.ui.activity.MainActivity
import com.example.myapplication.presentation.ui.adapter.PersonAdapter
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : Fragment(), View.OnClickListener {
    private lateinit var personViewModel: PersonViewModel
    private lateinit var navigationController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        personViewModel = ViewModelProviders.of(requireActivity()).get(PersonViewModel()::class.java)
        personViewModel.contextLiveData.value = requireActivity()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (requireActivity() as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        setHasOptionsMenu(false)
        val view =  inflater.inflate(R.layout.fragment_main, container, false)

        personViewModel.personLiveData.observe(viewLifecycleOwner, {
            setAdapter(it, view)

            when{
                it.size > 0 -> {
                    txt_empty_list.visibility = View.GONE
                }
                else -> {
                    txt_empty_list.visibility = View.VISIBLE
                }
            }
        })
        return view
    }

    override fun onResume() {
        super.onResume()

        personViewModel.retrievePeople()
    }

    private fun setAdapter(personModel: MutableList<PersonModel>, view: View) {
        view.recycler_people.layoutManager = LinearLayoutManager(requireActivity())
        view.recycler_people.adapter = PersonAdapter(this, personModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigationController = Navigation.findNavController(view)

        floating_action_button.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view){
            floating_action_button -> {
                navigationController.navigate(R.id.action_mainFragment_to_detailFragment)
            }
        }
    }

    fun onItemClick(person: PersonModel){
        val navOptions: NavOptions = NavOptions.Builder().setPopUpTo(R.id.action_mainFragment_to_detailFragment, false).build()
        navigationController.navigate(R.id.action_mainFragment_to_detailFragment, bundleOf("person" to person), navOptions)
    }

    fun onItemLongClick(person: PersonModel){
        personViewModel.deletePerson(person)
    }
}