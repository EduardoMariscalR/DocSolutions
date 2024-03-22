package com.android.eduardo.docsolutions.ui.screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.eduardo.docsolutions.data.datastore.UserPreferencesRepository
import com.android.eduardo.docsolutions.data.model.BodyLogIn
import com.android.eduardo.docsolutions.data.model.LogIn
import com.android.eduardo.docsolutions.data.remote.DocSolutionsRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException

sealed interface LogInUiState {
    data object Success : LogInUiState
    data object Error : LogInUiState
    data object Init : LogInUiState
}

class LogInViewModel(
    private val docSolutionsRepository: DocSolutionsRepository,
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {

    var logInUiState: LogInUiState by mutableStateOf(LogInUiState.Init)
        private set


    fun logIn(user: String, password: String) {
        viewModelScope.launch {
            logInUiState = LogInUiState.Init
            logInUiState =
                try {
                    val response = docSolutionsRepository.userLogIn(LogIn(BodyLogIn(user, password)))
                    if (response.isOK && !response.body.equals(null)){
                        userPreferencesRepository.saveCurrentToken(response.body.token)
                        LogInUiState.Success
                    } else {
                        LogInUiState.Error
                    }
                } catch (e: HttpException) {
                    LogInUiState.Error
                }

        }
    }


}


