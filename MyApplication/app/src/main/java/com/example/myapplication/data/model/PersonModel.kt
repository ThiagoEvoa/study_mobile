package com.example.myapplication.data.model

import android.os.Parcelable
import com.example.myapplication.domain.entity.PersonEntity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PersonModel(@SerializedName("_id") var id: String?, var name: String) :
    PersonEntity(id, name), Parcelable