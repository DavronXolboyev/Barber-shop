package com.doxmobile.barbershop.presentation.fragment.role

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.doxmobile.barbershop.R
import com.doxmobile.barbershop.app.App
import com.doxmobile.barbershop.databinding.FragmentUserRoleBinding
import com.doxmobile.barbershop.presentation.fragment.base.BaseFragment
import com.doxmobile.barbershop.util.applyBinding
import com.doxmobile.domain.model.Role
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserRoleFragment : BaseFragment<FragmentUserRoleBinding>(FragmentUserRoleBinding::inflate) {

    @Inject
    lateinit var viewModelFactory: UserRoleViewModelFactory

    private var viewModel: UserRoleViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as App).component.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[UserRoleViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        listenChanges()
    }

    private fun listenChanges() {
        repeatOn(Lifecycle.State.STARTED) {
            launch {
                viewModel!!.isChosenRole
                    .map { it }
                    .distinctUntilChanged()
                    .collect { isRoleSelected ->
                        /**
                         * The button is activated depending on the role selected
                         */
                        binding.continueTv.isEnabled = isRoleSelected
                    }
            }
            launch {
                viewModel!!.canNavigateToHome
                    .map { it }.distinctUntilChanged()
                    .collect { canNavigate ->
                        /**
                         * The ability to switch to another fragment when the continue button is clicked
                         */
                        if (canNavigate) {
                            findNavController().navigate(UserRoleFragmentDirections.actionUserRoleFragmentToHomeFragment())
                        }
                    }
            }
        }
    }

    private fun initListeners() = binding.applyBinding {
        continueTv.setOnClickListener {
            viewModel!!.setAction(Action.NavigateToHome)
        }

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radio_customer -> {
                    viewModel!!.setAction(Action.SetUserRole(Role.CUSTOMER))
                }
                R.id.radio_hairdresser -> {
                    viewModel!!.setAction(Action.SetUserRole(Role.HAIRDRESSER))
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel = null
    }

    companion object {
        const val TAG = "UserRoleFragment"
    }
}