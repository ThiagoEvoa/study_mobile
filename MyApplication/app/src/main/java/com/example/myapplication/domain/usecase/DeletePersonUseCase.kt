package com.example.myapplication.domain.usecase

import androidx.fragment.app.FragmentActivity
import com.example.myapplication.data.model.PersonModel
import com.example.myapplication.data.repository.DeletePersonRepository
import com.example.myapplication.domain.repository.IDeletePersonRepository

class DeletePersonUseCase(context: FragmentActivity) {
    private val iDeletePersonRepository: IDeletePersonRepository = DeletePersonRepository(context)

    fun deletePerson(personModel: PersonModel) {
        iDeletePersonRepository.deletePerson(personModel)
    }
}