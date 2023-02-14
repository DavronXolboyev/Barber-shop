package com.doxmobile.barbershop.util

/**
 * Created by Davron Xolboyev on 14.02.2023
 */

fun <T> T.applyBinding(block : T.() -> Unit){
    block(this)
}