package com.android.eduardo.docsolutions.data.model.getusersresponse


import com.google.gson.annotations.SerializedName

data class UsersResponse(
    @SerializedName("Body")
    val body: List<Body>,
    @SerializedName("EncryptedBody")
    val encryptedBody: Any?,
    @SerializedName("IsOK")
    val isOK: Boolean,
    @SerializedName("Messages")
    val messages: Any?,
    @SerializedName("ResponseCode")
    val responseCode: Int,
    @SerializedName("SecurityData")
    val securityData: Any?,
    @SerializedName("TransactionId")
    val transactionId: String
)