package com.example.myapplication.data.repository

import android.util.Log
import androidx.fragment.app.FragmentActivity
import com.example.myapplication.R
import com.example.myapplication.data.datasource.RetrofitConfig
import com.example.myapplication.data.model.PersonModel
import com.example.myapplication.domain.repository.IUpdatePersonRepository
import com.example.myapplication.util.DialogUtil
import com.google.gson.Gson
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdatePersonRepository(private val context: FragmentActivity) : IUpdatePersonRepository,
    Callback<MutableList<PersonModel>> {
    private var dialogUtil = DialogUtil()

    override fun updatePerson(personModel: PersonModel) {
        val requestBody = RequestBody.create(
            okhttp3.MediaType.parse("application/json; charset=utf-8"),
            Gson().toJson(personModel)
        )
        val call = RetrofitConfig(context).requestUpdatePerson().update(requestBody)
        call.enqueue(this)
    }

    override fun onResponse(
        call: Call<MutableList<PersonModel>>,
        response: Response<MutableList<PersonModel>>
    ) {
        dialogUtil.show(
            context,
            context.getString(R.string.dialog_information),
            context.getString(R.string.dialog_update)
        )
    }

    override fun onFailure(call: Call<MutableList<PersonModel>>, t: Throwable) {
        Log.e("Error: ", t.message!!)
        dialogUtil.show(
            context,
            context.getString(R.string.dialog_error),
            context.getString(R.string.dialog_error_message)
        )
    }
}