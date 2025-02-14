package com.example.doggy

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.doggy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.generateDogs.setBackgroundColor(Color.rgb(66, 134, 244))
        binding.recentDogs.setBackgroundColor(Color.rgb(66, 134, 244))

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.generateDogs.setOnClickListener {
            val intent = Intent(this, GenerateDogActivity::class.java)
            startActivity(intent)
        }
    }
}