package com.doxmobile.domain.useacase

import com.doxmobile.domain.model.create.CreateBarberShopReq
import com.doxmobile.domain.repository.CreateBarberShopRepository
import javax.inject.Inject

class CreateBarberShopUseCase @Inject constructor(createBarberShopRepository: CreateBarberShopRepository) {
    operator fun invoke(createBarberShopReq: CreateBarberShopReq){

    }
}