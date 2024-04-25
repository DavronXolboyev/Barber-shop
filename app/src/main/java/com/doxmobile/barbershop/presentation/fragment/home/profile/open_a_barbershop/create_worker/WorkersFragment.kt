package com.doxmobile.barbershop.presentation.fragment.home.profile.open_a_barbershop.create_worker

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.doxmobile.barbershop.databinding.FragmentWorkersBinding
import com.doxmobile.barbershop.presentation.fragment.base.BaseFragment
import com.doxmobile.barbershop.util.Navigate
import com.doxmobile.barbershop.util.applyBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WorkersFragment : BaseFragment<FragmentWorkersBinding>(FragmentWorkersBinding::inflate) {

    private val viewModel: WorkersViewModel by viewModels()
    private val adapterCreateWorker: AdapterCreateWorker by lazy {
        AdapterCreateWorker { oldList ->
            viewModel.addWorker(oldList)
        }
    }

    override fun initData() {
        binding.rvWorkers.adapter = adapterCreateWorker
    }

    override fun initListeners() = binding.applyBinding {

        toolbar.setNavigationOnClickListener {
            viewModel.navigateBack()
        }

        btnNext.setOnClickListener {
            viewModel.createWorkers(adapterCreateWorker.workers)
        }
    }

    override fun observeVM() {
        repeatOn(Lifecycle.State.STARTED) {
            launch {
                viewModel.workers.collect { newList ->
                    adapterCreateWorker.updateList(newList)
                }
            }
            launch {
                viewModel.navigate.collect { navigate ->
                    when (navigate) {
                        Navigate.BACK -> findNavController().popBackStack()
                        Navigate.NEXT -> {
                            // TODO: navigate next
                        }
                    }
                }
            }
        }
    }

}