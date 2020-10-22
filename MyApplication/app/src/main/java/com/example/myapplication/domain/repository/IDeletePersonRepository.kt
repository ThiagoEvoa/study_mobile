package com.example.myapplication.domain.repository

import com.example.myapplication.data.model.PersonModel

interface IDeletePersonRepository {
    fun deletePerson(personModel: PersonModel)
}