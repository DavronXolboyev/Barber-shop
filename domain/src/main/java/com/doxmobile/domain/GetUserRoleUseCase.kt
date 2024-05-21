package com.doxmobile.domain

import com.doxmobile.data.model.Role
import com.doxmobile.data.model.toRole
import com.doxmobile.data.repository.AppStorageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by Davron Xolboyev on 15.02.2023
 */
class GetUserRoleUseCase @Inject constructor(private val appStorageRepository: AppStorageRepository) {
    fun getRole(): Flow<Role> {
        return appStorageRepository.getUserRole().map { it.toRole() }
    }
}