package com.android.eduardo.docsolutions.ui.screens.newuserscreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.eduardo.docsolutions.data.datastore.UserPreferencesRepository
import com.android.eduardo.docsolutions.data.model.BodyNewUser
import com.android.eduardo.docsolutions.data.model.NewUser
import com.android.eduardo.docsolutions.data.model.RoleNewUser
import com.android.eduardo.docsolutions.data.remote.DocSolutionsRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException

sealed interface NewUserUiState {
    data class Error(val data: String) : NewUserUiState
    data object Success : NewUserUiState
    data object Init : NewUserUiState
}

class NewUserViewModel(
    private val docSolutionsRepository: DocSolutionsRepository,
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {

    var newUserUiState: NewUserUiState by mutableStateOf(NewUserUiState.Init)
        private set

    lateinit var token: String

    init {
        viewModelScope.launch {
            userPreferencesRepository.currentToken.collect {
                token = it
            }
        }
    }

    fun setNewUser(
        userName: String,
        password: String,
        name: String,
        lastNameF: String,
        lastNameM: String,
        email: String,
        phoneNumber: String,
    ) {
        viewModelScope.launch {
            newUserUiState = NewUserUiState.Init
            newUserUiState =
                try {
                    val response =
                        docSolutionsRepository.setNewUser(
                            body = NewUser(
                                BodyNewUser(
                                    name = name,
                                    fatherLastName = lastNameF,
                                    motherLastName = lastNameM,
                                    email = email,
                                    userName = userName,
                                    phoneNumber = phoneNumber,
                                    password = password,
                                    metadata = null,
                                    tenant = null,
                                    roles = listOf(
                                        RoleNewUser(
                                            id = 2,
                                            name = "Usuario Tradicional"
                                        )
                                    )
                                )
                            ),
                            authorization = token
                        )
                    if (response.isOK) {
                        NewUserUiState.Success
                    } else {
                        NewUserUiState.Error("${response.messages}")
                    }
                } catch (e: HttpException) {
                    NewUserUiState.Error("")
                }
        }
    }


}