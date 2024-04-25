package com.doxmobile.barbershop.util

import com.doxmobile.barbershop.R
import com.doxmobile.domain.model.Gender

/**
 * Created by Davron Xolboyev on 14.02.2023
 */

fun <T> T.applyBinding(block : T.() -> Unit){
    block(this)
}
fun Gender.getGender() = when (this) {
    Gender.MALE -> R.string.erkaklar
    Gender.FEMALE -> R.string.ayollar
}