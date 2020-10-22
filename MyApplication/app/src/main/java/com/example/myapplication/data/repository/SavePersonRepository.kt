package com.example.myapplication.data.repository

import android.util.Log
import androidx.fragment.app.FragmentActivity
import com.example.myapplication.R
import com.example.myapplication.data.datasource.RetrofitConfig
import com.example.myapplication.data.model.PersonModel
import com.example.myapplication.domain.repository.ISavePersonRepository
import com.example.myapplication.util.DialogUtil
import com.google.gson.Gson
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SavePersonRepository(private val context: FragmentActivity) : ISavePersonRepository,
    Callback<PersonModel> {
    private var dialogUtil = DialogUtil()

    override fun savePerson(personModel: PersonModel) {
        val requestBody = RequestBody.create(
            okhttp3.MediaType.parse("application/json; charset=utf-8"),
            Gson().toJson(personModel)
        )
        val call = RetrofitConfig(context).requestSavePerson().save(requestBody)
        call.enqueue(this)
    }

    override fun onResponse(call: Call<PersonModel>, response: Response<PersonModel>) {
        dialogUtil.show(context, context.getString(R.string.dialog_information), context.getString(R.string.dialog_save))
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