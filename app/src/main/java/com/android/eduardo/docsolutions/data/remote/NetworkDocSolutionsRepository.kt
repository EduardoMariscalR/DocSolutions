package com.android.eduardo.docsolutions.data.remote

import com.android.eduardo.docsolutions.data.model.GetUsers
import com.android.eduardo.docsolutions.data.model.LogIn
import com.android.eduardo.docsolutions.data.model.NewUser
import com.android.eduardo.docsolutions.data.model.getusersresponse.UsersResponse
import com.android.eduardo.docsolutions.data.model.loginresponse.LogInResponse
import com.android.eduardo.docsolutions.data.model.newuserresponse.NewUserResponse

class NetworkDocSolutionsRepository(
    private val apiService: ApiService
): DocSolutionsRepository {
    override suspend fun userLogIn(logIn: LogIn): LogInResponse = apiService.userLogIn(logIn)

    override suspend fun getUser(body: GetUsers, authorization: String): UsersResponse = apiService.getUser(body,authorization)

    override suspend fun setNewUser(body: NewUser, authorization: String): NewUserResponse = apiService.setNewUser(body,authorization)

}