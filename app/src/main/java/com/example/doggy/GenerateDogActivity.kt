package com.example.doggy

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.doggy.databinding.ActivityGenerateDogBinding
import com.example.doggy.util.PreferenceManager
import com.example.doggy.viewModels.GenerateDogViewModel

class GenerateDogActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGenerateDogBinding
    private lateinit var viewModel: GenerateDogViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityGenerateDogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.generate.setBackgroundColor(Color.rgb(66, 134, 244))
        viewModel = ViewModelProvider(this)[GenerateDogViewModel::class.java]

        setupClickListeners()
        setupObservers()
    }

    private fun setupClickListeners() {
        binding.generate.setOnClickListener {
            viewModel.fetchDogImage()
        }
    }

    private fun setupObservers() {
        viewModel.dogLiveData.observe(this) {
            PreferenceManager.addDog(it)
            Glide.with(this)
                .load(it.message)
                .into(binding.imageView)
        }

        viewModel._errorLiveData.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }
}