package com.example.myapplication.presentation.presenter

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.model.PersonModel
import com.example.myapplication.domain.usecase.DeletePersonUseCase
import com.example.myapplication.domain.usecase.RetrievePeopleUseCase
import com.example.myapplication.domain.usecase.SavePersonUseCase
import com.example.myapplication.domain.usecase.UpdatePersonUseCase

class PersonViewModel : ViewModel() {
    val contextLiveData = MutableLiveData<FragmentActivity>()
    val personLiveData = MutableLiveData<MutableList<PersonModel>>()

    fun retrievePeople() {
        contextLiveData.value?.let { RetrievePeopleUseCase(it).retrievePeople() }
    }

    fun savePerson(personModel: PersonModel) {
        contextLiveData.value?.let { SavePersonUseCase(it).savePerson(personModel) }
    }

    fun updatePerson(personModel: PersonModel) {
        contextLiveData.value?.let { UpdatePersonUseCase(it).updatePerson(personModel) }
    }

    fun deletePerson(personModel: PersonModel) {
        contextLiveData.value?.let { DeletePersonUseCase(it).deletePerson(personModel) }
    }
}