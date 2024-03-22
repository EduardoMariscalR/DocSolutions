package com.android.eduardo.docsolutions.data.model.loginresponse


import com.android.eduardo.docsolutions.data.model.loginresponse.Function
import com.google.gson.annotations.SerializedName

data class Module(
    @SerializedName("Functions")
    val functions: List<Function>,
    @SerializedName("Id")
    val id: Int,
    @SerializedName("Name")
    val name: String
)