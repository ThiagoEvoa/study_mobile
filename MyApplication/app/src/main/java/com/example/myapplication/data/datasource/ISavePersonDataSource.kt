package com.example.myapplication.data.datasource

import com.example.myapplication.data.model.PersonModel
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ISavePersonDataSource {
    @POST("person")
    fun save(@Body body: RequestBody): Call<PersonModel>
}