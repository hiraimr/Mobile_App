package com.example.myapplication5

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication5.databinding.ActivityLiveBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class LiveActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLiveBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLiveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set the selected item in the BottomNavigationView
        binding.bottomNavigation.selectedItemId = R.id.navigation_live

        // Handle navigation item clicks
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_live -> {
                    // Stay on LiveActivity
                    true
                }
                R.id.navigation_dining -> {
                    // Navigate to DiningActivity
                    startActivity(Intent(this, DiningActivity::class.java))
                    finish() // Optional: close this activity if you want
                    true
                }
                R.id.navigation_delivery -> {
                    // Navigate to DeliveryActivity
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish() // Optional: close this activity if you want
                    true
                }
                else -> false
            }
        }
    }
}
