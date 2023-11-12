package com.example.codigocodetestproject1.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.codigocodetestproject1.databinding.ActivityGetStartBinding

class GetStartActivity : AppCompatActivity() {
    private lateinit var binding : ActivityGetStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpListener()
    }


    private fun setUpListener(){
        binding.btnGetStart.setOnClickListener {
            startActivity(SelectHealthConcernsActivity.newIntent(this))
        }
    }
}