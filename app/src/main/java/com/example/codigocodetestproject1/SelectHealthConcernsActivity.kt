package com.example.codigocodetestproject1

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.codigocodetestproject1.databinding.ActivityGetStartBinding
import com.example.codigocodetestproject1.databinding.ActivitySelectHealthConcernsBinding
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class SelectHealthConcernsActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySelectHealthConcernsBinding
    private val selectedChips = mutableListOf<String>()

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
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setUpChip(){
       val chipGroup = findViewById<ChipGroup>(R.id.chipGroup)
      //  val submitButton = findViewById(R.id.submitButton)

        val chipNames = listOf("Sleep", "Stress", "Joint Support", "Energy", "Other1", "Other2", "Other3","Sleep", "Stress", "Joint Support", "Energy", "Other1", "Other2", "Other3")

        for (chipName in chipNames) {
            val chip = Chip(this)
            chip.backgroundDrawable = getDrawable(R.drawable.ic_button_background)
            chip.isCheckable = true
            chipGroup.addView(chip)
        }

        chipGroup.setOnCheckedChangeListener { group, checkedId ->
            val chip = group.findViewById<Chip>(checkedId)
            chip?.let {
                if (it.isChecked) {
                    if (selectedChips.size < 5) {
                        selectedChips.add(it.text.toString())
                    } else {
                        it.isChecked = false
                        Toast.makeText(
                            this,
                            "You can select up to 5 chips",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    selectedChips.remove(it.text.toString())
                }
            }
        }
    }
}