package com.doxmobile.barbershop.presentation.fragment

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.navigation.fragment.findNavController
import com.doxmobile.barbershop.presentation.fragment.base.BaseFragment
import com.example.barbershop.databinding.FragmentSplashBinding

class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        object : CountDownTimer(2000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                /**
                 * Navigate to second direction
                 */
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToUserRoleFragment())
            }
        }.start()
    }
}