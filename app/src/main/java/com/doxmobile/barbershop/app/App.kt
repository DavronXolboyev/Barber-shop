package com.doxmobile.barbershop.app

import android.app.Application
import com.doxmobile.barbershop.di.Component
import com.doxmobile.barbershop.di.DaggerComponent
import com.doxmobile.barbershop.di.module.AppModule

/**
 * Created by Davron Xolboyev on 13.02.2023
 */
class App : Application() {
    lateinit var component: Component
    override fun onCreate() {
        super.onCreate()
        component = DaggerComponent.builder().appModule(AppModule(this)).build()
    }
}