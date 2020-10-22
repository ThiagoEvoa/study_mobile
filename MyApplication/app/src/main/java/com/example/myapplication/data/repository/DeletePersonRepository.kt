package com.example.myapplication.data.repository

import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.example.myapplication.data.datasource.RetrofitConfig
import com.example.myapplication.data.model.PersonModel
import com.example.myapplication.domain.repository.IDeletePersonRepository
import com.example.myapplication.presentation.presenter.PersonViewModel
import com.example.myapplication.util.DialogUtil
import com.google.gson.Gson
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DeletePersonRepository(private val context: FragmentActivity) : IDeletePersonRepository,
    Callback<PersonModel> {
    private var personViewModel: PersonViewModel =
        ViewModelProviders.of(context).get(PersonViewModel::class.java)
    private var dialogUtil = DialogUtil()

    override fun deletePerson(personModel: PersonModel) {
        val requestBody = RequestBody.create(
            okhttp3.MediaType.parse("application/json; charset=utf-8"),
            Gson().toJson(personModel)
        )
        val call = RetrofitConfig(context).requestDeletePerson().delete(requestBody)
        call.enqueue(this)
    }

    override fun onResponse(call: Call<PersonModel>, response: Response<PersonModel>) {
        personViewModel.retrievePeople()
        dialogUtil.show(
            context,
            context.getString(R.string.dialog_information),
            context.getString(R.string.dialog_delete)
        )
    }

    override fun onFailure(call: Call<PersonModel>, t: Throwable) {
        Log.e("Error: ", t.message!!)
        dialogUtil.show(
            context,
            context.getString(R.string.dialog_error),
            context.getString(R.string.dialog_error_message)
        )
    }
}