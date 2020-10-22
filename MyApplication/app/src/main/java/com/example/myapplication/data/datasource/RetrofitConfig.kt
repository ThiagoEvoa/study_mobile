package com.example.myapplication.data.datasource

import android.content.Context
import com.example.myapplication.util.PropertiesUtil
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig(context: Context) {
    var retrofit: Retrofit
    var propertiesUtil: PropertiesUtil = PropertiesUtil(context)

    init {
        retrofit = Retrofit.Builder().baseUrl(propertiesUtil.getProperty("BASE_URL") as String)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun requestPeople(): IRetrievePeopleDataSource =
        retrofit.create(IRetrievePeopleDataSource::class.java)

    fun requestSavePerson(): ISavePersonDataSource =
        retrofit.create(ISavePersonDataSource::class.java)

    fun requestUpdatePerson(): IUpdatePersonDataSource =
        retrofit.create(IUpdatePersonDataSource::class.java)

    fun requestDeletePerson(): IDeletePersonDataSource =
        retrofit.create(IDeletePersonDataSource::class.java)
}