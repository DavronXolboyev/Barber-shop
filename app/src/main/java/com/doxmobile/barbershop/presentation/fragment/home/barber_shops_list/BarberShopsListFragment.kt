package com.doxmobile.barbershop.presentation.fragment.home.barber_shops_list

import android.os.Bundle
import android.view.View
import com.doxmobile.barbershop.app.App
import com.doxmobile.barbershop.databinding.FragmentBarberShopsListBinding
import com.doxmobile.barbershop.presentation.fragment.base.BaseFragment

class BarberShopsListFragment :
    BaseFragment<FragmentBarberShopsListBinding>(FragmentBarberShopsListBinding::inflate){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as App).component.inject(this)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}