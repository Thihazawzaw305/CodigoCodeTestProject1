package com.example.codigocodetestproject1.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.RawContacts.Data
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
import com.example.codigocodetestproject1.data.ChipList
import com.example.codigocodetestproject1.data.ChipVO
import com.example.codigocodetestproject1.data.healthConcernData
import com.example.codigocodetestproject1.databinding.ActivitySelectHealthConcernsBinding
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.gson.Gson
import org.json.JSONArray

class SelectHealthConcernsActivity : AppCompatActivity() {


    private lateinit var chipGroup: ChipGroup
    private lateinit var binding : ActivitySelectHealthConcernsBinding
    private lateinit var mPrioritizeRecyclerViewAdapter: PrioritizeRecyclerViewAdapter
    companion object{
        fun newIntent(context : Context): Intent {
            return Intent(context, SelectHealthConcernsActivity::class.java)
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectHealthConcernsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setUpChip()
       setUpRecyclerView()


    }

    private fun setUpChip(){
        val data : ChipList =Gson().fromJson(healthConcernData, ChipList::class.java)
        chipGroup = findViewById(R.id.chipGroup)
        for (chipItem in data.data) {
            val chip = Chip(this)
            chip.text = chipItem.name
            chip.isCheckable = true

            chip.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked && chipGroup.checkedChipIds.size > 5) {
                    chip.isChecked = false
                }
                else   chip.isChecked = true
            }
            chipGroup.addView(chip)


        }


    }





    private fun setUpRecyclerView(){
        mPrioritizeRecyclerViewAdapter = PrioritizeRecyclerViewAdapter()
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = mPrioritizeRecyclerViewAdapter
       val data = listOf("item1","item2","item3","item4")
        mPrioritizeRecyclerViewAdapter.setNewData(data)
        itemTouchHelper.attachToRecyclerView(binding.recyclerView)

    }







    private val itemTouchHelper by lazy {
        val simpleItemTouchCallBack =
            object : ItemTouchHelper.SimpleCallback(UP or DOWN or START or END, 0) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    val adapter = recyclerView.adapter as PrioritizeRecyclerViewAdapter
                    val from = viewHolder.adapterPosition
                    val to = target.adapterPosition
                    adapter.notifyItemMoved(from, to)

                    return true
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                }

                override fun onSelectedChanged(
                    viewHolder: RecyclerView.ViewHolder?,
                    actionState: Int
                ) {
                    super.onSelectedChanged(viewHolder, actionState)
                    if (actionState == ACTION_STATE_DRAG) {
                        viewHolder?.itemView?.alpha = 0.8f
                    }
                }
            }
        ItemTouchHelper(simpleItemTouchCallBack)
    }}





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

//
//val chipGroup = findViewById<ChipGroup>(R.id.chipGroup)
//
//val chipData = ChipVO::class.java
//chipDataList.addAll(Gson().fromJson(HealthConcernData, Array<ChipVO>::class.java).toList())
//
//for (chipItem in chipDataList) {
//    val chip = Chip(this)
//    chip.text = chipItem.name
//    chip.setOnCheckedChangeListener { buttonView, isChecked ->
//        if (isChecked) {
//            if (selectedChips.size < 5) {
//                selectedChips.apply {chipItem.toString()  }
//                mPrioritizeRecyclerViewAdapter.setNewData(selectedChips)
//            } else {
//                chip.isChecked = false
//                Toast.makeText(
//                    this,
//                    "You can select up to 5 chips",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//        } else {
//
//            mPrioritizeRecyclerViewAdapter.setNewData(selectedChips)
//        }
//    }
//    chipGroup.addView(chip)
//}

