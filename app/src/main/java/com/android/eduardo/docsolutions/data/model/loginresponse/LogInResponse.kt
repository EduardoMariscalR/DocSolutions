package com.android.eduardo.docsolutions.data.model.loginresponse


import com.android.eduardo.docsolutions.data.model.loginresponse.Body
import com.google.gson.annotations.SerializedName

data class LogInResponse(
    @SerializedName("Body")
    val body: Body,
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