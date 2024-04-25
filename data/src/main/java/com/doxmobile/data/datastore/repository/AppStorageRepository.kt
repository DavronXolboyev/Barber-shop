package com.doxmobile.data.datastore.repository

import kotlinx.coroutines.flow.Flow

/**
 * Created by Davron Xolboyev on 14.02.2023
 */
interface AppStorageRepository {
    fun hasTheUserChosenARole(): Flow<Boolean>
    suspend fun updateHasTheUserChosenARole(isChosen : Boolean)
    fun getUserRole() : Flow<String>
    suspend fun setUserRole(roleName : String)
}