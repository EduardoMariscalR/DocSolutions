package com.android.eduardo.docsolutions.data.model.getusersresponse


import com.google.gson.annotations.SerializedName

data class Role(
    @SerializedName("Id")
    val id: Int,
    @SerializedName("Name")
    val name: String
)