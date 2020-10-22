package com.example.myapplication.data.repository

import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.data.datasource.RetrofitConfig
import com.example.myapplication.data.model.PersonModel
import com.example.myapplication.domain.repository.IRetrievePeopleRepository
import com.example.myapplication.presentation.presenter.PersonViewModel
import com.example.myapplication.util.LoadingUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrievePeopleRepository(private val context: FragmentActivity) : IRetrievePeopleRepository,
    Callback<MutableList<PersonModel>> {
    private var personViewModel: PersonViewModel =
        ViewModelProviders.of(context).get(PersonViewModel::class.java)
    private var dialogUtil = LoadingUtil()

    init {
        dialogUtil.show(context)
    }

    override fun retrievePeople() {
        val call = RetrofitConfig(context).requestPeople().retrieve()
        call.enqueue(this)
    }

    override fun onResponse(
        call: Call<MutableList<PersonModel>>,
        response: Response<MutableList<PersonModel>>
    ) {
        dialogUtil.dismissDialog()
        personViewModel.personLiveData.value = response.body()
    }

    override fun onFailure(call: Call<MutableList<PersonModel>>, t: Throwable) {
        dialogUtil.dismissDialog()
        Log.e("Error: ", t.message!!)
    }
}