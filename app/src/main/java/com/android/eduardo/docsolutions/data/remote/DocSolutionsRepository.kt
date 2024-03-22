package com.android.eduardo.docsolutions.data.remote

import com.android.eduardo.docsolutions.data.model.GetUsers
import com.android.eduardo.docsolutions.data.model.LogIn
import com.android.eduardo.docsolutions.data.model.NewUser
import com.android.eduardo.docsolutions.data.model.getusersresponse.UsersResponse
import com.android.eduardo.docsolutions.data.model.loginresponse.LogInResponse
import com.android.eduardo.docsolutions.data.model.newuserresponse.NewUserResponse

interface DocSolutionsRepository {
    suspend fun userLogIn(logIn: LogIn) : LogInResponse
    suspend fun getUser(body: GetUsers, authorization: String): UsersResponse
    suspend fun setNewUser(body: NewUser,authorization: String): NewUserResponse
}