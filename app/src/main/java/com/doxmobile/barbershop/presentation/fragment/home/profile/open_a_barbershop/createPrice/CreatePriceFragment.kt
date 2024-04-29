package com.doxmobile.barbershop.presentation.fragment.home.profile.open_a_barbershop.createPrice

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.doxmobile.barbershop.databinding.FragmentCreatePriceBinding
import com.doxmobile.barbershop.presentation.fragment.base.BaseFragment
import com.doxmobile.barbershop.util.Navigate
import com.doxmobile.barbershop.util.applyBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CreatePriceFragment :
    BaseFragment<FragmentCreatePriceBinding>(FragmentCreatePriceBinding::inflate) {

    private val viewModel: CreatePriceViewModel by viewModels()
    private val adapterCreatePrices: AdapterCreatePrices by lazy {
        AdapterCreatePrices {
            viewModel.addPrice(it)
        }
    }

    override fun initData() {
        binding.rvWorkers.adapter = adapterCreatePrices
    }

    override fun initListeners() = binding.applyBinding {

        toolbar.setNavigationOnClickListener {
            viewModel.navigateBack()
        }

        btnNext.setOnClickListener {
            viewModel.createWorkers(adapterCreatePrices.priceList)
        }
    }

    override fun observeVM() {
        repeatOn(Lifecycle.State.STARTED) {
            launch {
                viewModel.prices.collect { newList ->
                    adapterCreatePrices.updateList(newList)
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