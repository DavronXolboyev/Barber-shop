package com.doxmobile.data.datastore.usecase

import com.doxmobile.data.datastore.repository.AppStorageRepository
import com.doxmobile.domain.model.Role
import com.doxmobile.domain.model.toRole
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