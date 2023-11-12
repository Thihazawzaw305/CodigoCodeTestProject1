package com.example.codigocodetestproject1.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codigocodetestproject1.databinding.ViewHolderAllergeiesBinding
import com.example.codigocodetestproject1.databinding.ViewHolderPrioritizeBinding

class AllergeiesRecyclerViewAdapter(private val allergeiesList : List<String>):RecyclerView.Adapter<AllergeiesRecyclerViewAdapter.AllergeiesViewHolder> (){

    inner class AllergeiesViewHolder(private val binding : ViewHolderAllergeiesBinding):RecyclerView.ViewHolder(binding.root){
        fun bindData(allergeies : String){
            binding.tvAllergiesFromViewHolder.text = allergeies

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllergeiesViewHolder {
      val binding = ViewHolderAllergeiesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
   return AllergeiesViewHolder(binding)
    }

    override fun getItemCount(): Int {
      return allergeiesList.size
    }

    override fun onBindViewHolder(holder: AllergeiesViewHolder, position: Int) {
      if (allergeiesList.isNotEmpty()){
          holder.bindData(allergeiesList[position])
      }
    }

}