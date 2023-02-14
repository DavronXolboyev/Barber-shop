package com.doxmobile.domain.local

import kotlinx.coroutines.flow.Flow

/**
 * Created by Davron Xolboyev on 14.02.2023
 */
class GetHasTheUserChosenARoleUseCase(private val appStorageRepository: AppStorageRepository) {
    fun getHasTheUserChosenARole(): Flow<Boolean> = appStorageRepository.hasTheUserChosenARole()
}