package com.android.eduardo.docsolutions.data.model.loginresponse


import com.google.gson.annotations.SerializedName

data class Function(
    @SerializedName("Id")
    val id: Int,
    @SerializedName("Name")
    val name: String
)