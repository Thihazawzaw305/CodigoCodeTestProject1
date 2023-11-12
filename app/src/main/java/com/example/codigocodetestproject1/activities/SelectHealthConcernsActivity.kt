package com.example.codigocodetestproject1.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.HeaderViewListAdapter
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.ACTION_STATE_DRAG
import androidx.recyclerview.widget.ItemTouchHelper.DOWN
import androidx.recyclerview.widget.ItemTouchHelper.END
import androidx.recyclerview.widget.ItemTouchHelper.START
import androidx.recyclerview.widget.ItemTouchHelper.UP
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.codigocodetestproject1.R
import com.example.codigocodetestproject1.adapters.PrioritizeRecyclerViewAdapter
import com.example.codigocodetestproject1.data.HealthConcernData
import com.example.codigocodetestproject1.data.vos.ChipVO
import com.example.codigocodetestproject1.databinding.ActivitySelectHealthConcernsBinding
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.gson.Gson

class SelectHealthConcernsActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySelectHealthConcernsBinding
    private val selectedChips = mutableListOf<String>()
    private lateinit var mPrioritizeRecyclerViewAdapter: PrioritizeRecyclerViewAdapter
    private val itemList = mutableListOf<String>()
    private val chipDataList = mutableListOf<ChipVO>()

    companion object{
        fun newIntent(context : Context): Intent {
            return Intent(context, SelectHealthConcernsActivity::class.java)
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySelectHealthConcernsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setUpChip()
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        prepareData()
        mPrioritizeRecyclerViewAdapter = PrioritizeRecyclerViewAdapter(itemList)
        binding.recyclerView.adapter = mPrioritizeRecyclerViewAdapter
        itemTouchHelper.attachToRecyclerView(binding.recyclerView)

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setUpChip(){
       val chipGroup = findViewById<ChipGroup>(R.id.chipGroup)
//      //  val submitButton = findViewById(R.id.submitButton)
//
//        val chipNames = listOf("Sleep", "Stress", "Joint Support", "Energy", "Other1", "Other2", "Other3","Sleep", "Stress", "Joint Support", "Energy", "Other1", "Other2", "Other3")
//
//        for (chipName in chipNames) {
//            val chip = Chip(this)
//            chip.backgroundDrawable = getDrawable(R.drawable.ic_button_background)
//            //chip.chipBackgroundColor = getColor(com.google.android.material.R.color.mtrl_btn_transparent_bg_color)
//            chip.text = chipName
//            chip.isCheckable = true
//            chipGroup.addView(chip)
//        }
//
//        chipGroup.setOnCheckedChangeListener { group, checkedId ->
//            val chip = group.findViewById<Chip>(checkedId)
//            chip?.let {
//                if (it.isChecked) {
//                    if (selectedChips.size < 5) {
//                        selectedChips.add(it.text.toString())
//                    } else {
//                        it.isChecked = false
//                        Toast.makeText(
//                            this,
//                            "You can select up to 5 chips",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                } else {
//                    selectedChips.remove(it.text.toString())
//                }
//              }}

        val chipData = ChipVO::class.java
        chipDataList.addAll(Gson().fromJson(HealthConcernData, Array<ChipVO>::class.java).toList())

        for (chipItem in chipDataList) {
            val chip = Chip(this)
            chip.text = chipItem.name
            chip.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    if (selectedChips.size < 5) {
                        selectedChips.add(chipItem.toString())
                        updateRecyclerView()
                    } else {
                        chip.isChecked = false
                        Toast.makeText(
                            this,
                            "You can select up to 5 chips",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    selectedChips.remove(chipItem)
                    updateRecyclerView()
                }
            }
            chipGroup.addView(chip)
        }

        val layoutManager = LinearLayoutManager(this)
        val adapter = HeaderViewListAdapter(selectedChips)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    private fun prepareData(){
        itemList.add("item 1")
        itemList.add("item 2")
        itemList.add("item 3")
        itemList.add("item 4")
        itemList.add("item 5")
    }

    private val itemTouchHelper by lazy {
        val simpleItemTouchCallBack = object  : ItemTouchHelper.SimpleCallback(UP or DOWN or START or END, 0){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
               val adapter = recyclerView.adapter as PrioritizeRecyclerViewAdapter
                val from = viewHolder.adapterPosition
                val to = target.adapterPosition
                adapter.notifyItemMoved(from,to)

                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

            }

            override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
                super.onSelectedChanged(viewHolder, actionState)
                if(actionState == ACTION_STATE_DRAG){
                    viewHolder?.itemView?.alpha = 0.8f
                }
            }
        }
        ItemTouchHelper(simpleItemTouchCallBack)
    }



}