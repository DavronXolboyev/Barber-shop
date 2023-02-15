package com.doxmobile.barbershop.presentation.fragment.home.barber_fav_shops_list

import android.os.Bundle
import android.view.View
import com.doxmobile.barbershop.app.App
import com.doxmobile.barbershop.databinding.FragmentBarberFavShopsListBinding
import com.doxmobile.barbershop.presentation.fragment.base.BaseFragment

class BarberFavShopsListFragment :
    BaseFragment<FragmentBarberFavShopsListBinding>(FragmentBarberFavShopsListBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as App).component.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}