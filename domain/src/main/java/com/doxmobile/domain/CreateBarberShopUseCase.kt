package com.doxmobile.domain


import com.doxmobile.data.model.create.CreateBarberShopReq
import com.doxmobile.data.repository.CreateBarberShopRepository
import javax.inject.Inject

class CreateBarberShopUseCase @Inject constructor(createBarberShopRepository: CreateBarberShopRepository) {
    operator fun invoke(createBarberShopReq: CreateBarberShopReq){

    }
}