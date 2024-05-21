package com.doxmobile.domain

import com.doxmobile.data.repository.AppStorageRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Davron Xolboyev on 14.02.2023
 */
class GetHasTheUserChosenARoleUseCase @Inject constructor(private val appStorageRepository: AppStorageRepository) {
    fun getHasTheUserChosenARole(): Flow<Boolean> = appStorageRepository.hasTheUserChosenARole()
}