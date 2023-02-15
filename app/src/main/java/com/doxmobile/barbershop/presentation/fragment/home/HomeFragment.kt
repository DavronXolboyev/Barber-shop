package com.doxmobile.barbershop.presentation.fragment.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.doxmobile.barbershop.R
import com.doxmobile.barbershop.app.App
import com.doxmobile.barbershop.databinding.FragmentHomeBinding
import com.doxmobile.barbershop.presentation.fragment.base.BaseFragment
import com.doxmobile.barbershop.util.applyBinding
import com.doxmobile.domain.model.Role
import kotlinx.coroutines.launch
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
        observeUI()
        initView()
    }

    private fun initView() = binding.applyBinding{
        val navHostFragment = childFragmentManager.findFragmentById(R.id.home_fragment_container) as NavHostFragment
        homeBottomNavigation.setupWithNavController(navController = navHostFragment.navController)
    }

    private fun observeUI() {
        repeatOn(Lifecycle.State.STARTED) {
            launch {
                viewModel!!.hasTheUserChosenARole.collect {
                    if (!it) {
                        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToUserRoleFragment())
                    }
                }
            }
            launch {
                viewModel!!.role.collect { role ->
                    Log.i(TAG, "onViewCreated: ROLE -> $role")
                    binding.homeBottomNavigation.menu
                        .findItem(R.id.profileFragment).isVisible = role == Role.HAIRDRESSER
                }
            }
        }
    }

    companion object {
        const val TAG = "HomeFragment"
    }
}