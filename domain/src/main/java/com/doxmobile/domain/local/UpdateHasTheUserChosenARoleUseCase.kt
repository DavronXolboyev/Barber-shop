package com.doxmobile.domain.local

import javax.inject.Inject

/**
 * Created by Davron Xolboyev on 14.02.2023
 */
class UpdateHasTheUserChosenARoleUseCase @Inject constructor(private val appStorageRepository: AppStorageRepository) {
    suspend fun updateUserRole(isChosen: Boolean) {
        appStorageRepository.updateHasTheUserChosenARole(isChosen = isChosen)
    }
}