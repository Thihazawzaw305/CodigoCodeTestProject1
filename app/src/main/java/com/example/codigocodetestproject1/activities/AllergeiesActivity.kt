package com.example.codigocodetestproject1.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.codigocodetestproject1.databinding.ActivityAllergeiesBinding
import com.example.codigocodetestproject1.databinding.ActivitySelectDietBinding

class AllergeiesActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAllergeiesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllergeiesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpListener()
    }

    private fun setUpListener(){
        binding.btnNextFromAllergeies.setOnClickListener {
            startActivity(Intent(this,GetPersonalizedVitaminActivity::class.java))
        }

    }
}