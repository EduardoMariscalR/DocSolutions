package com.android.eduardo.docsolutions.data.model.loginresponse


import com.google.gson.annotations.SerializedName

data class Body(
    @SerializedName("JWTExpireTimeOfflineMinutes")
    val jWTExpireTimeOfflineMinutes: Int,
    @SerializedName("Token")
    val token: String,
    @SerializedName("UserLoginData")
    val userLoginData: UserLoginData
)