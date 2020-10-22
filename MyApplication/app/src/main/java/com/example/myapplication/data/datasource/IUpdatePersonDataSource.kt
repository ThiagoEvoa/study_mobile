package com.example.myapplication.data.datasource

import com.example.myapplication.data.model.PersonModel
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.PUT

interface IUpdatePersonDataSource {
    @PUT("person")
    fun update(@Body body: RequestBody): Call<MutableList<PersonModel>>
}