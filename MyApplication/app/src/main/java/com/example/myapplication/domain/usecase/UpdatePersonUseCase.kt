package com.example.myapplication.domain.usecase

import androidx.fragment.app.FragmentActivity
import com.example.myapplication.data.model.PersonModel
import com.example.myapplication.data.repository.UpdatePersonRepository
import com.example.myapplication.domain.repository.IUpdatePersonRepository

class UpdatePersonUseCase(context: FragmentActivity) {
    private val iUpdatePersonRepository: IUpdatePersonRepository = UpdatePersonRepository(context)

    fun updatePerson(personModel: PersonModel) {
        iUpdatePersonRepository.updatePerson(personModel)
    }
}