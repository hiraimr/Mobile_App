package com.example.myapplication5

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication5.databinding.ActivityCarnivalBinding

class CarnivalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCarnivalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarnivalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.featuredButton.setOnClickListener {
            // Navigate back to DiningActivity
            val intent = Intent(this, DiningActivity::class.java)
            startActivity(intent)
            finish()  // Finish this activity to prevent going back to it
        }

        // Load static images into the image views (assuming they are in the drawable folder)
        binding.imageOne.setImageResource(R.drawable.c2)
        binding.imageTwo.setImageResource(R.drawable.c3)

        // Additional dynamic logic or data can be loaded here, if needed
    }
}
