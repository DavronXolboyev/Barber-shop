package com.doxmobile.barbershop.presentation.fragment.home.profile.open_a_barbershop.createPrice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.RecyclerView
import com.doxmobile.barbershop.databinding.ItemAddPriceBinding
import com.doxmobile.barbershop.databinding.ItemCreatePriceBinding
import com.doxmobile.barbershop.util.applyBinding

class AdapterCreatePrices(private val onAddClick: (List<CreatePrice>) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var priceList = listOf<CreatePrice>()
        private set

    inner class VhPrice(private val binding: ItemCreatePriceBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(createPrice: CreatePrice) = binding.applyBinding {
            etHairStyle.setText(createPrice.hairStyle ?: "")
            etHairCost.setText(createPrice.cost ?: "")

            etHairStyle.doAfterTextChanged {
                priceList[adapterPosition].hairStyle = it?.toString()
            }
            etHairCost.doAfterTextChanged {
                priceList[adapterPosition].cost = it?.toString()
            }
        }
    }

    inner class VhAddPrice(private val binding: ItemAddPriceBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind() {
            binding.addPrice.setOnClickListener {
                onAddClick(priceList)
            }
        }
    }

    fun updateList(newList: List<CreatePrice>) {
        priceList = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        return when {
            p1 == 0 -> {
                VhAddPrice(
                    ItemAddPriceBinding.inflate(
                        LayoutInflater.from(p0.context),
                        p0,
                        false
                    )
                )
            }

            p1 == 1 -> {
                VhPrice(
                    ItemCreatePriceBinding.inflate(
                        LayoutInflater.from(p0.context),
                        p0,
                        false
                    )
                )
            }

            else -> {
                VhPrice(
                    ItemCreatePriceBinding.inflate(
                        LayoutInflater.from(p0.context),
                        p0,
                        false
                    )
                )
            }
        }
    }

    override fun getItemCount(): Int = priceList.size

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        if (p0 is VhPrice) {
            p0.onBind(priceList[p1])
        } else if (p0 is VhAddPrice) {
            p0.onBind()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return priceList[position].type
    }
}