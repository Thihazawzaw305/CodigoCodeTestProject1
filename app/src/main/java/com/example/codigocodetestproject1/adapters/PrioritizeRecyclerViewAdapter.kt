package com.example.codigocodetestproject1.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codigocodetestproject1.data.vos.ChipVO
import com.example.codigocodetestproject1.databinding.ViewHolderPrioritizeBinding

class PrioritizeRecyclerViewAdapter(private val selectedChips: List<ChipVO>):RecyclerView.Adapter<PrioritizeRecyclerViewAdapter.PrioritizeViewHolder> (){

    inner class PrioritizeViewHolder(private val binding : ViewHolderPrioritizeBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(dataText : ChipVO){
            binding.tvDataText.text =  dataText.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrioritizeViewHolder {
      val binding = ViewHolderPrioritizeBinding.inflate(LayoutInflater.from(parent.context),parent,false)
   return PrioritizeViewHolder(binding)
    }

    override fun getItemCount(): Int {
return     selectedChips.size
    }

    override fun onBindViewHolder(holder: PrioritizeViewHolder, position: Int) {
      holder.bind(selectedChips[position])
    }
    fun updateData(newData: List<ChipVO>) {
        selectedChips.clear()
        selectedChips.addAll(newData)
        notifyDataSetChanged()
    }

}