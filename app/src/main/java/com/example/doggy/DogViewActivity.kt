package com.example.doggy

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doggy.databinding.ActivityDogViewBinding
import com.example.doggy.util.PreferenceManager
import com.example.doggy.util.RvAdapter

class DogViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDogViewBinding
    private lateinit var adapter: RvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDogViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnClear.setBackgroundColor(Color.rgb(66, 134, 244))
        adapter = RvAdapter(PreferenceManager.getData())
        binding.rv.adapter = adapter
        binding.rv.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        setupClickListeners()
    }

    private fun setupClickListeners(){
        binding.btnClear.setOnClickListener {
            adapter.updateItems(emptyList())
            PreferenceManager.clearData()
        }
    }
}