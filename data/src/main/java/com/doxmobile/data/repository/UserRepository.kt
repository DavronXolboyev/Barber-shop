package com.doxmobile.data.repository

import kotlinx.coroutines.flow.Flow

typealias IsSuccessful = Boolean

interface UserRepository {
    fun login(uniqueKey: String, deviceName: String): Flow<IsSuccessful>
    fun logOut(): Flow<IsSuccessful>
    fun doRate(barberShopId: String, rate: Int): Flow<IsSuccessful>
}