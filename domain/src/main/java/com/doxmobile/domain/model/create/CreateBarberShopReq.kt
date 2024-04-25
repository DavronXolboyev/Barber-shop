package com.doxmobile.domain.model.create

import com.doxmobile.domain.model.Gender

data class CreateBarberShopReq(
    val name: String? = null,
    val uniqueName: String? = null,
    val password: String? = null,
    val fromTime: String? = null,
    val toTime: String? = null,
    val froWhom: Gender? = null
)