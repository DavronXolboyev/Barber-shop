package com.doxmobile.domain.local

/**
 * Created by Davron Xolboyev on 14.02.2023
 */
class UpdateHasTheUserChosenARoleUseCase(private val appStorageRepository: AppStorageRepository) {
    suspend fun updateUserRole(){
        appStorageRepository.updateHasTheUserChosenARole()
    }
}