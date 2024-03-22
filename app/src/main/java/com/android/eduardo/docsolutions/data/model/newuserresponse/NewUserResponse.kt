package com.android.eduardo.docsolutions.data.model.newuserresponse


import com.google.gson.annotations.SerializedName

data class NewUserResponse(
    @SerializedName("Body")
    val body: Boolean,
    @SerializedName("EncryptedBody")
    val encryptedBody: Any? = null,
    @SerializedName("IsOK")
    val isOK: Boolean,
    @SerializedName("Messages")
    val messages: String? = null,
    @SerializedName("ResponseCode")
    val responseCode: Int,
    @SerializedName("SecurityData")
    val securityData: Any? = null,
    @SerializedName("TransactionId")
    val transactionId: String
)