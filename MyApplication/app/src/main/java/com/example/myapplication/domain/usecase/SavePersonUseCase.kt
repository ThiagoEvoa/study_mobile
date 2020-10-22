package com.example.myapplication.domain.usecase

import androidx.fragment.app.FragmentActivity
import com.example.myapplication.data.model.PersonModel
import com.example.myapplication.data.repository.SavePersonRepository
import com.example.myapplication.domain.repository.ISavePersonRepository

class SavePersonUseCase(context: FragmentActivity) {
    private val iSavePersonRepository: ISavePersonRepository = SavePersonRepository(context)

    fun savePerson(personModel: PersonModel) {
        iSavePersonRepository.savePerson(personModel)
    }
}