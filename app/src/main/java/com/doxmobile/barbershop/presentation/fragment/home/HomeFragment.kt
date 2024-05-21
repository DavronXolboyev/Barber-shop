package com.doxmobile.barbershop.presentation.fragment.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.doxmobile.barbershop.R
import com.doxmobile.barbershop.databinding.FragmentHomeBinding
import com.doxmobile.barbershop.presentation.fragment.base.BaseFragment
import com.doxmobile.barbershop.util.applyBinding
import com.doxmobile.data.model.Role
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeUI()
        initView()
    }

    private fun initView() = binding.applyBinding {
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.home_fragment_container) as NavHostFragment
        homeBottomNavigation.setupWithNavController(navController = navHostFragment.navController)
        navHostFragment.navController.addOnDestinationChangedListener(object :
            NavController.OnDestinationChangedListener {
            override fun onDestinationChanged(
                controller: NavController,
                destination: NavDestination,
                arguments: Bundle?
            ) {
                val isVisible = destination.id in listOf(
                    R.id.profileFragment,
                    R.id.barberFavShopsListFragment,
                    R.id.barberShopsListFragment
                )
                homeBottomNavigation.isVisible = isVisible
            }
        })
    }

    private fun observeUI() {
        repeatOn(Lifecycle.State.STARTED) {
            launch {
                viewModel.hasTheUserChosenARole.collect {
                    if (!it) {
                        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToUserRoleFragment())
                    }
                }
            }
            launch {
                viewModel.role.collect { role ->
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