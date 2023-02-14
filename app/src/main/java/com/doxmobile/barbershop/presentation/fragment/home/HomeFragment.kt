package com.doxmobile.barbershop.presentation.fragment.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.doxmobile.barbershop.app.App
import com.doxmobile.barbershop.databinding.FragmentHomeBinding
import com.doxmobile.barbershop.presentation.fragment.base.BaseFragment
import javax.inject.Inject

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    @Inject
    lateinit var homeViewModelFactory: HomeViewModelFactory

    private var viewModel: HomeViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as App).component.inject(this)
        viewModel = ViewModelProvider(this, homeViewModelFactory)[HomeViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        repeatOn(Lifecycle.State.STARTED){
            viewModel!!.hasTheUserChosenARole.collect{
                if (!it) {
                    findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToUserRoleFragment())
                }
            }
        }
    }
    companion object{
        const val TAG = "HomeFragment"
    }
}