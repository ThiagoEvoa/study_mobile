package com.example.myapplication.domain.usecase

import androidx.fragment.app.FragmentActivity
import com.example.myapplication.data.model.PersonModel
import com.example.myapplication.data.repository.RetrievePeopleRepository
import com.example.myapplication.domain.repository.IRetrievePeopleRepository

class RetrievePeopleUseCase(context: FragmentActivity) {
    private val iRetrievePeopleRepository: IRetrievePeopleRepository = RetrievePeopleRepository(context)

    fun retrievePeople() {
        iRetrievePeopleRepository.retrievePeople()
    }
}