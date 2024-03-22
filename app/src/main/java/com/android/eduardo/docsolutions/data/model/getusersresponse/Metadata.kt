package com.android.eduardo.docsolutions.data.model.getusersresponse


import com.google.gson.annotations.SerializedName

data class Metadata(
    @SerializedName("GroupName")
    val groupName: String,
    @SerializedName("Name")
    val name: String,
    @SerializedName("Value")
    val value: String
)