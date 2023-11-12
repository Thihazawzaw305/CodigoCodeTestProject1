package com.example.codigocodetestproject1.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codigocodetestproject1.databinding.ViewHolderPrioritizeBinding

class PrioritizeRecyclerViewAdapter(private val itemList : List<String>):RecyclerView.Adapter<PrioritizeRecyclerViewAdapter.PrioritizeViewHolder> (){

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
return     itemList.size
    }

    override fun onBindViewHolder(holder: PrioritizeViewHolder, position: Int) {
      holder.bind(itemList[position])
    }


}