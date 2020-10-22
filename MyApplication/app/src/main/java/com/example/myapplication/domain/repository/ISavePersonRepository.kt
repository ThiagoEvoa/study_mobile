package com.example.myapplication.domain.repository

import com.example.myapplication.data.model.PersonModel

interface ISavePersonRepository {
    fun savePerson(personModel: PersonModel)
}