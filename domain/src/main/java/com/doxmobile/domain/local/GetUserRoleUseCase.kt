package com.doxmobile.domain.local

import com.doxmobile.domain.model.Role
import com.doxmobile.domain.model.toRole
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Created by Davron Xolboyev on 15.02.2023
 */
class GetUserRoleUseCase(private val appStorageRepository: AppStorageRepository) {
    fun getRole(): Flow<Role> {
        return appStorageRepository.getUserRole().map { it.toRole() }
    }
}