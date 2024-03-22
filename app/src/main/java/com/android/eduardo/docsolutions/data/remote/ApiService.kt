package com.android.eduardo.docsolutions.data.remote

import com.android.eduardo.docsolutions.data.model.BodyGetUsers
import com.android.eduardo.docsolutions.data.model.GetUsers
import com.android.eduardo.docsolutions.data.model.LogIn
import com.android.eduardo.docsolutions.data.model.NewUser
import com.android.eduardo.docsolutions.data.model.getusersresponse.UsersResponse
import com.android.eduardo.docsolutions.data.model.loginresponse.LogInResponse
import com.android.eduardo.docsolutions.data.model.newuserresponse.NewUserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    @Headers(
        "Content-Type: application/json",
        "Accept: application/json"
    )
    @POST("OnBoardingPre/WebApi/api/authentication/authentication")
    suspend fun userLogIn(@Body logIn: LogIn) : LogInResponse

    @Headers(
        "Content-Type: application/json",
        "Accept: application/json"
    )
    @POST("OnBoardingPre/WebApi/api/user/GetUsers")
    suspend fun getUser(@Body body: GetUsers, @Header("Authorization") authorization: String) : UsersResponse

    @Headers(
        "Content-Type: application/json",
        "Accept: application/json"
    )
    @POST("OnBoardingPre/WebApi/api/user/GetUsers")
    suspend fun setNewUser(@Body body: NewUser, @Header("Authorization") authorization: String) : NewUserResponse


}