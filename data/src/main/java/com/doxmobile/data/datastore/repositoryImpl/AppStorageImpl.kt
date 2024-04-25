package com.doxmobile.data.datastore.repositoryImpl

import com.doxmobile.data.datastore.AppStorage
import com.doxmobile.data.datastore.repository.AppStorageRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by Davron Xolboyev on 14.02.2023
 */
class AppStorageImpl(private val appStorage: AppStorage) : AppStorageRepository {
    override fun hasTheUserChosenARole(): Flow<Boolean> {
        return appStorage.hasTheUserChosenARoleFlow
    }

    override suspend fun updateHasTheUserChosenARole(isChosen : Boolean) {
        appStorage.updateHasTheUserChosenARole(isChosen = isChosen)
    }

    override fun getUserRole(): Flow<String> {
        return appStorage.roleFlow
    }

    override suspend fun setUserRole(roleName: String) {
        appStorage.setRole(roleName = roleName)
    }
}