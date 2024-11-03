package com.example.myapplication5

import android.content.Intent
import android.os.Bundle
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication5.databinding.ActivityAccountBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class AccountActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set up view binding
        binding = ActivityAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set the selected item in the BottomNavigationView
        binding.bottomNavigation.selectedItemId = R.id.navigation_account

        // Handle navigation item clicks
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_account -> {
                    // Stay on AccountActivity
                    true
                }
                R.id.navigation_live -> {
                    startActivity(Intent(this, LiveActivity::class.java))
                    finish()
                    true
                }
                R.id.navigation_dining -> {
                    startActivity(Intent(this, DiningActivity::class.java))
                    finish()
                    true
                }
                R.id.navigation_delivery -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                    true
                }
                else -> false
            }
        }

        // Initialize views
        binding.tvUserName.text = "Hira"
        binding.tvUserEmail.text = "hirabhatti804@gmail.com"

        // Set up "View activity" click listener
        binding.tvViewActivity.setOnClickListener {
            // Action to view activity, e.g., open an activity or show a toast
            startActivity(Intent(this, UserActivity::class.java))
        }

        // Set up "Join Zomato Gold" section click listener
        // In AccountActivity.kt

        binding.joinZomatoGoldSection.setOnClickListener {
            // Navigate to the joinZomatoGoldSection activity when clicked
            startActivity(Intent(this, joinZomatoGoldSection::class.java))
        }

        // Handle options in the grid layout
        // Handle options in the grid layout
        binding.collectionsOption.setOnClickListener {
            // Start CollectionOptionsActivity when "Collections" option is clicked
            startActivity(Intent(this, CollectionOptionsActivity::class.java))
        }

        binding.moneyOption.setOnClickListener {
            // Action for "Money" option
        }

        // Set up Veg Mode toggle switch listener
        val vegModeSwitch: Switch = binding.vegModeSwitch
        vegModeSwitch.setOnCheckedChangeListener { _, isChecked ->
            // Handle the state change for Veg Mode
        }

        // Handle appearance settings click
        binding.appearanceOption.setOnClickListener {
            // Action for "Appearance" option
        }

        // Handle rating section click
        binding.ratingOption.setOnClickListener {
            // Action for "Your Rating" option
        }
    }
}
