package com.android.eduardo.docsolutions.data.model.getusersresponse


import com.google.gson.annotations.SerializedName

data class Body(
    @SerializedName("Active")
    val active: Boolean,
    @SerializedName("CreationDate")
    val creationDate: String,
    @SerializedName("Email")
    val email: String?,
    @SerializedName("FatherLastName")
    val fatherLastName: String,
    @SerializedName("Id")
    val id: Int,
    @SerializedName("Locked")
    val locked: Boolean,
    @SerializedName("Metadata")
    val metadata: List<Metadata>,
    @SerializedName("MotherLastName")
    val motherLastName: String,
    @SerializedName("Name")
    val name: String,
    @SerializedName("Password")
    val password: Any?,
    @SerializedName("PhoneNumber")
    val phoneNumber: String?,
    @SerializedName("Roles")
    val roles: List<Role>,
    @SerializedName("Tenant_Id")
    val tenantId: Any?,
    @SerializedName("Username")
    val username: String
)