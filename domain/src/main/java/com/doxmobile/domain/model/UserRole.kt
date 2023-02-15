package com.doxmobile.domain.model

/**
 * Created by Davron Xolboyev on 13.02.2023
 */
enum class Role {
    CUSTOMER, HAIRDRESSER;
}

fun String.toRole() = if (this == Role.CUSTOMER.name) {
    Role.CUSTOMER
} else {
    Role.HAIRDRESSER
}