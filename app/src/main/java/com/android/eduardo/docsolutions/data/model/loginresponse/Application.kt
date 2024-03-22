package com.android.eduardo.docsolutions.data.model.loginresponse


import com.google.gson.annotations.SerializedName

data class Application(
    @SerializedName("Id")
    val id: Int,
    @SerializedName("Modules")
    val modules: List<Module>,
    @SerializedName("Name")
    val name: String
)