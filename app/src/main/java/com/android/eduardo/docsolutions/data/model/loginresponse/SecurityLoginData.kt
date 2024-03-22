package com.android.eduardo.docsolutions.data.model.loginresponse


import com.google.gson.annotations.SerializedName

data class SecurityLoginData(
    @SerializedName("Applications")
    val applications: List<Application>,
    @SerializedName("Roles")
    val roles: List<Role>
)