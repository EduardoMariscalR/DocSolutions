package com.android.eduardo.docsolutions.data.model.loginresponse


import com.google.gson.annotations.SerializedName

data class UserLoginData(
    @SerializedName("CurrentFileId")
    val currentFileId: Int,
    @SerializedName("Email")
    val email: String,
    @SerializedName("FatherLastName")
    val fatherLastName: String,
    @SerializedName("Id")
    val id: Int,
    @SerializedName("Metadata")
    val metadata: List<Metadata>,
    @SerializedName("MotherLastName")
    val motherLastName: String,
    @SerializedName("Name")
    val name: String,
    @SerializedName("PhoneNumber")
    val phoneNumber: String,
    @SerializedName("SecurityLoginData")
    val securityLoginData: SecurityLoginData,
    @SerializedName("Username")
    val username: String
)