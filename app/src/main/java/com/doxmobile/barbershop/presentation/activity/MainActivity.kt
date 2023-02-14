package com.doxmobile.barbershop.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.doxmobile.barbershop.R
import com.doxmobile.barbershop.app.App

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (applicationContext as App).component.inject(this)
    }
}