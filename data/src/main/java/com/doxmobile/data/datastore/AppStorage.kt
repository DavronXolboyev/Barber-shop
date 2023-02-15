package com.doxmobile.data.datastore

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Singleton

/**
 * Created by Davron Xolboyev on 14.02.2023
 */
private const val STORAGE_NAME = "app_storage"
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = STORAGE_NAME)

@Singleton
class AppStorage(private val context: Context) {

    private val hasTheUserChosenARole = booleanPreferencesKey(name = KEY_HAS_CHOSEN_ROLE)
    private val role = stringPreferencesKey(name = KEY_ROLE)


    val hasTheUserChosenARoleFlow: Flow<Boolean> = context.dataStore.data.map { preference ->
        preference[hasTheUserChosenARole] ?: false
    }
    val roleFlow: Flow<String> = context.dataStore.data.map { preference ->
        preference[role] ?: ""
    }

    suspend fun setRole(roleName: String) {
        context.dataStore.edit { settings ->
            settings[role] = roleName
        }
    }

    suspend fun updateHasTheUserChosenARole() {
        Log.i(TAG, "updateHasTheUserChosenARole: worked")
        context.dataStore.edit { settings ->
            settings[hasTheUserChosenARole] = true
        }
    }

    companion object {
        const val KEY_HAS_CHOSEN_ROLE = "has_role"
        const val KEY_ROLE = "role"
        const val TAG = "AppStorage"
    }
}