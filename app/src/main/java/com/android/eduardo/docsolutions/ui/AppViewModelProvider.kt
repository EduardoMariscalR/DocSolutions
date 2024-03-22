package com.android.eduardo.docsolutions.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.android.eduardo.docsolutions.DocSolutionsApplication
import com.android.eduardo.docsolutions.ui.screens.login.LogInViewModel
import com.android.eduardo.docsolutions.ui.screens.newuserscreen.NewUserViewModel
import com.android.eduardo.docsolutions.ui.screens.userlistscreen.UserListViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            LogInViewModel(
                docSolutionsApplication().container.docSolutionsRepository,
                docSolutionsApplication().userPreferencesRepository
            )
        }
        initializer {
            UserListViewModel(
                docSolutionsApplication().container.docSolutionsRepository,
                docSolutionsApplication().userPreferencesRepository
            )
        }
        initializer {
            NewUserViewModel(
                docSolutionsApplication().container.docSolutionsRepository,
                docSolutionsApplication().userPreferencesRepository
            )
        }
    }
}

fun CreationExtras.docSolutionsApplication(): DocSolutionsApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as DocSolutionsApplication)
