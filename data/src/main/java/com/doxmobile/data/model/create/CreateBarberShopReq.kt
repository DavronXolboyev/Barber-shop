package com.doxmobile.data.model.create

import com.doxmobile.data.model.Gender

data class CreateBarberShopReq(
    val name: String? = null,
    val uniqueName: String? = null,
    val password: String? = null,
    val fromTime: String? = null,
    val toTime: String? = null,
    val froWhom: Gender? = null
)