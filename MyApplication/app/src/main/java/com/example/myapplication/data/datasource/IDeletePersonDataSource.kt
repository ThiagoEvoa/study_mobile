package com.example.myapplication.data.datasource

import com.example.myapplication.data.model.PersonModel
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.HTTP

interface IDeletePersonDataSource {
    @HTTP(method = "DELETE", path = "person", hasBody = true)
    fun delete(@Body body: RequestBody): Call<PersonModel>
}