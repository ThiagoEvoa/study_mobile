package com.example.myapplication.data.datasource

import com.example.myapplication.data.model.PersonModel
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface IRetrievePeopleDataSource {
    @GET("people")
    fun retrieve(): Call<MutableList<PersonModel>>
}