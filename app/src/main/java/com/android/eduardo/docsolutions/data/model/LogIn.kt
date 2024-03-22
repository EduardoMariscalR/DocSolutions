package com.android.eduardo.docsolutions.data.model

import com.google.gson.annotations.SerializedName

data class LogIn(
    val body: BodyLogIn
)

data class BodyLogIn(
    val Username : String,
    val Password : String
)

data class GetUsers(
    val body: BodyGetUsers
)

data class BodyGetUsers (
    val SearchText: String
)

data class NewUser(
    @SerializedName("Body")
    val body: BodyNewUser
)

data class BodyNewUser(
    @SerializedName("Email")
    val email: String,
    @SerializedName("FatherLastName")
    val fatherLastName: String,
    @SerializedName("Metadata")
    val metadata: Any?,
    @SerializedName("MotherLastName")
    val motherLastName: String,
    @SerializedName("Name")
    val name: String,
    @SerializedName("Password")
    val password: String,
    @SerializedName("PhoneNumber")
    val phoneNumber: String,
    @SerializedName("Roles")
    val roles: List<RoleNewUser>,
    @SerializedName("Tenant")
    val tenant: Any?,
    @SerializedName("UserName")
    val userName: String
)

data class RoleNewUser(
    @SerializedName("Id")
    val id: Int = 2,
    @SerializedName("Name")
    val name: String = "Usuario Tradicional"
)
