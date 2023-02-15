package com.doxmobile.barbershop.presentation.fragment.home.barbershops_list

import android.os.Bundle
import android.view.View
import com.doxmobile.barbershop.app.App
import com.doxmobile.barbershop.databinding.FragmentBarbershopsListBinding
import com.doxmobile.barbershop.presentation.fragment.base.BaseFragment

class BarbershopsListFragment :
    BaseFragment<FragmentBarbershopsListBinding>(FragmentBarbershopsListBinding::inflate){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as App).component.inject(this)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}