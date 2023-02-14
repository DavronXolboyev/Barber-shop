package com.doxmobile.data.datastore.repository

import com.doxmobile.data.datastore.AppStorage
import com.doxmobile.domain.local.AppStorageRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Davron Xolboyev on 14.02.2023
 */
class AppStorageImpl(private val appStorage: AppStorage) : AppStorageRepository {
    override fun hasTheUserChosenARole(): Flow<Boolean> {
        return appStorage.hasTheUserChosenARoleFlow
    }

    override suspend fun updateHasTheUserChosenARole() {
        appStorage.updateHasTheUserChosenARole()
    }
}