package com.doxmobile.barbershop.presentation.fragment.home.profile.open_a_barbershop.create_worker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.RecyclerView
import com.doxmobile.barbershop.databinding.ItemAddWorkerBinding
import com.doxmobile.barbershop.databinding.ItemCreateBarberBinding
import com.doxmobile.barbershop.util.applyBinding

class AdapterCreateWorker(private val onAddClick: (List<CreateWorker>) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var workers = listOf<CreateWorker>()
        private set

    inner class VhWorker(private val binding: ItemCreateBarberBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(createWorker: CreateWorker) = binding.applyBinding {
            etBarberName.setText(createWorker.name ?: "")
            etBarberPhoneNumber.setText(createWorker.phoneNumber ?: "")

            etBarberName.doAfterTextChanged {
                workers[adapterPosition].name = it?.toString()
            }
            etBarberPhoneNumber.doAfterTextChanged {
                workers[adapterPosition].phoneNumber = it?.toString()
            }
        }
    }

    inner class VhAddWorker(private val binding: ItemAddWorkerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind() {
            binding.addWorker.setOnClickListener {
                onAddClick(workers)
            }
        }
    }

    fun updateList(newList: List<CreateWorker>) {
        workers = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        return when {
            p1 == 0 -> {
                VhAddWorker(
                    ItemAddWorkerBinding.inflate(
                        LayoutInflater.from(p0.context),
                        p0,
                        false
                    )
                )
            }

            p1 == 1 -> {
                VhWorker(
                    ItemCreateBarberBinding.inflate(
                        LayoutInflater.from(p0.context),
                        p0,
                        false
                    )
                )
            }

            else -> {
                VhWorker(
                    ItemCreateBarberBinding.inflate(
                        LayoutInflater.from(p0.context),
                        p0,
                        false
                    )
                )
            }
        }
    }

    override fun getItemCount(): Int = workers.size

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        if (p0 is VhWorker) {
            p0.onBind(workers[p1])
        } else if (p0 is VhAddWorker) {
            p0.onBind()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return workers[position].type
    }
}