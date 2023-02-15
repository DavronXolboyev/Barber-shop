package com.doxmobile.domain.local

/**
 * Created by Davron Xolboyev on 15.02.2023
 */
class SetRoleUseCase(private val appStorageRepository: AppStorageRepository) {
    suspend fun setRole(roleName: String) {
        appStorageRepository.setUserRole(roleName = roleName)
    }
}