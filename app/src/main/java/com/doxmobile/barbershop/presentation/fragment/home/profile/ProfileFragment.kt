package com.doxmobile.barbershop.presentation.fragment.home.profile

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.doxmobile.barbershop.databinding.FragmentProfileBinding
import com.doxmobile.barbershop.presentation.fragment.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonOpenABarbershop.setOnClickListener {
            findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToCreateBarberShop())
        }

    }

}