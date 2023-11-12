package com.example.codigocodetestproject1.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.codigocodetestproject1.databinding.ActivitySelectDietBinding

class SelectDietActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySelectDietBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectDietBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpListener()
    }
    private fun setUpListener(){
        binding.btnNextFromDiet.setOnClickListener {
            startActivity(Intent(this,AllergeiesActivity::class.java))
        }

    }
}