package com.example.myapplication.domain.repository

import com.example.myapplication.data.model.PersonModel

interface IUpdatePersonRepository {
    fun updatePerson(personModel: PersonModel)
}