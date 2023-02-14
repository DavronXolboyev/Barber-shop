package com.doxmobile.domain.local

import kotlinx.coroutines.flow.Flow

/**
 * Created by Davron Xolboyev on 14.02.2023
 */
interface AppStorageRepository {
    fun hasTheUserChosenARole(): Flow<Boolean>
    suspend fun updateHasTheUserChosenARole()
}