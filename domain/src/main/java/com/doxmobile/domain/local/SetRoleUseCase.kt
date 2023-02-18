package com.doxmobile.domain.local

import javax.inject.Inject

/**
 * Created by Davron Xolboyev on 15.02.2023
 */
class SetRoleUseCase @Inject constructor(private val appStorageRepository: AppStorageRepository) {
    suspend fun setRole(roleName: String) {
        appStorageRepository.setUserRole(roleName = roleName)
    }
}