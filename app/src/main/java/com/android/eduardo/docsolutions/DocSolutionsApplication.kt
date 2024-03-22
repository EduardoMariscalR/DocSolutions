package com.android.eduardo.docsolutions

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.android.eduardo.docsolutions.data.datastore.UserPreferencesRepository
import com.android.eduardo.docsolutions.di.AppContainer
import com.android.eduardo.docsolutions.di.DefaultAppContainer

private const val USER_TOKEN = "user_token"
private val  Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_TOKEN)

class DocSolutionsApplication: Application() {

    lateinit var container: AppContainer
    lateinit var userPreferencesRepository: UserPreferencesRepository

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer(this)
        userPreferencesRepository = UserPreferencesRepository(dataStore)
    }

}