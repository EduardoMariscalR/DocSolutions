package com.android.eduardo.docsolutions.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

class UserPreferencesRepository(
    private val dataStore: DataStore<Preferences>
) {
    val currentToken: Flow<String> = dataStore.data
        .catch {
            if (it is IOException) {
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
        .map { preferences ->
            preferences[CURRENT_TOKEN] ?: ""
        }

    private companion object {
        val CURRENT_TOKEN = stringPreferencesKey("")
    }

    suspend fun saveCurrentToken(currentToken: String) {
        dataStore.edit { preferences ->
            preferences[CURRENT_TOKEN] = currentToken
        }
    }
}