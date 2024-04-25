package com.doxmobile.barbershop.presentation.fragment.home.profile.open_a_barbershop.create

import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.doxmobile.barbershop.R
import com.doxmobile.barbershop.databinding.FragmentCreateBarberShopBinding
import com.doxmobile.barbershop.presentation.fragment.base.BaseFragment
import com.doxmobile.barbershop.util.Navigate
import com.doxmobile.barbershop.util.applyBinding
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateBarberShopFragment :
    BaseFragment<FragmentCreateBarberShopBinding>(FragmentCreateBarberShopBinding::inflate) {

    private val viewModel: CreateBarberShopVM by viewModels()

    override fun initListeners() = binding.applyBinding {
        etFromTime.setOnClickListener {
            showTimePicker { time ->
                etFromTime.text = time
                viewModel.setFromTime(time)
            }
        }
        etToTime.setOnClickListener {
            showTimePicker { time ->
                etToTime.text = time
                viewModel.setToTime(time)
            }
        }
        toolbar.setNavigationOnClickListener {
            viewModel.navigateBack()
        }
        btnNext.setOnClickListener {
            val sPassword = etBshPassword2.text?.toString()
            if (sPassword.isNullOrEmpty()) {
                tilBshPassword2.error = getString(R.string.tasdiqlash_parolini_kiriting)
                return@setOnClickListener
            }

            if (viewModel.isPasswordSame(sPassword)) {
                viewModel.createBarberShop()
            } else {
                tilBshPassword2.error = getString(R.string.parol_mos_emas)
            }
        }

        etBshPassword.doAfterTextChanged {
            tilBshPassword.error = NO_ERROR
            if (!viewModel.setPassword(it?.toString() ?: return@doAfterTextChanged)) {
                tilBshPassword.error = getString(R.string.bosh_joy_ishlatilmasin)
            }
        }
        etBshPassword2.doAfterTextChanged {
            tilBshPassword2.error = NO_ERROR
        }
        etBshName.doAfterTextChanged {
            tilBshName.error = NO_ERROR
        }
        etBshUniqueName.doAfterTextChanged {
            tilBshUniqueName.error = NO_ERROR
        }
    }

    private fun showTimePicker(onPositiveClick: (String) -> Unit) {
        val fromTime = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_24H)
            .setHour(8)
            .setMinute(0)
            .setTitleText(R.string.ochilish_vaqti)
            .setInputMode(MaterialTimePicker.INPUT_MODE_CLOCK)
            .build()
        fromTime.addOnPositiveButtonClickListener {
            val time = String.format("%02d:%02d", fromTime.hour, fromTime.minute)
            onPositiveClick(time)
        }

        fromTime.show(childFragmentManager, TAG)
    }

    override fun observeVM() {
        repeatOn(Lifecycle.State.RESUMED) {
            viewModel.navigate.collect {
                // TODO: Keyingi qadamga o'tish
                when (it) {
                    Navigate.BACK -> {
                        findNavController().popBackStack()
                    }

                    Navigate.NEXT -> {
                        findNavController().navigate(CreateBarberShopFragmentDirections.actionCreateBarberShopToWorkersFragment())
                    }
                }
            }
        }
    }

    companion object {
        const val TAG = "CreateBarberShop"
        const val NO_ERROR = ""
    }
}