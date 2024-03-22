package com.android.eduardo.docsolutions.ui.screens.userlistscreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.eduardo.docsolutions.data.datastore.UserPreferencesRepository
import com.android.eduardo.docsolutions.data.model.BodyGetUsers
import com.android.eduardo.docsolutions.data.model.GetUsers
import com.android.eduardo.docsolutions.data.model.getusersresponse.UsersResponse
import com.android.eduardo.docsolutions.data.remote.DocSolutionsRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException

sealed interface UserListUiState {
    data class Success(val data: UsersResponse) : UserListUiState
    data object Error : UserListUiState
    data object Init : UserListUiState
}

class UserListViewModel(
    private val docSolutionsRepository: DocSolutionsRepository,
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {

    var userListUiState: UserListUiState by mutableStateOf(UserListUiState.Init)
        private set

    lateinit var token: String

    init {
        viewModelScope.launch {
            userPreferencesRepository.currentToken.collect {
                token = it
            }
        }
    }

    fun searchUsers(name: String) {
        viewModelScope.launch {
            userListUiState = UserListUiState.Init
            userListUiState =
                try {
                    val response =
                        docSolutionsRepository.getUser(GetUsers(BodyGetUsers(name)), token)
                    if (response.body.isEmpty()){
                        UserListUiState.Error
                    } else{
                        UserListUiState.Success(response)
                    }
                } catch (e: HttpException) {
                    UserListUiState.Error
                }
        }
    }


}