package com.doxmobile.barbershop.presentation.fragment.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Created by Davron Xolboyev on 13.02.2023
 */
typealias Inflater <VB> = (LayoutInflater, ViewGroup?, Boolean) -> VB

open class BaseFragment<VB : ViewBinding>(private val inflate: Inflater<VB>) : Fragment() {
    private var _binding: VB? = null
    val binding get() =  _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    protected fun repeatOn(
        state: Lifecycle.State,
        action: suspend CoroutineScope.() -> Unit
    ) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(state, action)
        }
    }
}