package com.example.codigocodetestproject1.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codigocodetestproject1.data.ChipVO
import com.example.codigocodetestproject1.databinding.ViewHolderPrioritizeBinding

class PrioritizeRecyclerViewAdapter():RecyclerView.Adapter<PrioritizeRecyclerViewAdapter.PrioritizeViewHolder> (){
    private var mSelectedChips: List<String> = listOf()
    inner class PrioritizeViewHolder(private val binding : ViewHolderPrioritizeBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(dataText : String){
            binding.tvDataText.text =  dataText
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrioritizeViewHolder {
      val binding = ViewHolderPrioritizeBinding.inflate(LayoutInflater.from(parent.context),parent,false)
   return PrioritizeViewHolder(binding)
    }

    override fun getItemCount(): Int {
return    mSelectedChips.size
    }

    override fun onBindViewHolder(holder: PrioritizeViewHolder, position: Int) {
      holder.bind(mSelectedChips[position])
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(selectedChip: List<String>) {
       mSelectedChips = selectedChip
        notifyDataSetChanged()
    }

}