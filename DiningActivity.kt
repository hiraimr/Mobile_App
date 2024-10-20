//package com.example.myapplication5
//
//import android.content.Intent
//import android.graphics.Color
//import android.os.Bundle
//import android.widget.TextView
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import androidx.appcompat.widget.SearchView
//import com.example.myapplication5.databinding.ActivityDiningBinding
//import com.google.android.material.bottomnavigation.BottomNavigationView
//
//class DiningActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityDiningBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityDiningBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        // Set the selected item in the BottomNavigationView
//        binding.bottomNavigation.selectedItemId = R.id.navigation_dining
//
//        // Customize SearchView
//        val searchView = binding.searchView // Accessing SearchView using binding
//        val searchTextView = searchView.findViewById<TextView>(androidx.appcompat.R.id.search_src_text)
//
//        // Customize the hint
//        searchTextView.hint = "Search restaurants"
//        searchTextView.setHintTextColor(Color.BLACK) // Set hint color to black
//        searchTextView.setTypeface(null, android.graphics.Typeface.BOLD) // Set hint text to bold
//
//        // Handle Filters Button click
//        binding.filtersButton.setOnClickListener {
//            Toast.makeText(this, "Filters Button Clicked", Toast.LENGTH_SHORT).show()
//        }
//
//        binding.carnivalOffersButton.setOnClickListener {
//            Toast.makeText(this, "Carnival Offers clicked", Toast.LENGTH_SHORT).show()
//        }
//
//        // Handle Offers Button click
//        binding.offersButton.setOnClickListener {
//            Toast.makeText(this, "Offers Button Clicked", Toast.LENGTH_SHORT).show()
//        }
//
//        // Bottom navigation item selection listener
//        binding.bottomNavigation.setOnItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.navigation_delivery -> {
//                    startActivity(Intent(this, HomeActivity::class.java))
//                    finish()
//                    true
//                }
//                R.id.navigation_live -> {
//                    // Navigate to LiveActivity when Live button is clicked
//                    startActivity(Intent(this, LiveActivity::class.java))
//                    finish()
//                    true
//                }
//                else -> false
//            }
//        }
//    }
//}
package com.example.myapplication5

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication5.databinding.ActivityDiningBinding

class DiningActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDiningBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiningBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Customize SearchView
        val searchView = binding.searchView
        val searchTextView = searchView.findViewById<TextView>(androidx.appcompat.R.id.search_src_text)

        // Customize the hint
        searchTextView.hint = "Search restaurants"
        searchTextView.setHintTextColor(Color.BLACK)
        searchTextView.setTypeface(null, android.graphics.Typeface.BOLD)

        // Handle Filters Button click
        binding.filtersButton.setOnClickListener {
            val intent = Intent(this, FiltersActivity::class.java)
            startActivity(intent)
        }

        // Handle Carnival Offers Button click
//        binding.carnivalOffersButton.setOnClickListener {
//            Toast.makeText(this, "Carnival Offers clicked", Toast.LENGTH_SHORT).show()
//        }
        binding.carnivalOffersButton.setOnClickListener {
            val intent = Intent(this, CarnivalActivity::class.java)
            startActivity(intent)
        }

        // Handle Offers Button click
        binding.offersButton.setOnClickListener {
            val intent = Intent(this, OffActivity::class.java)
            startActivity(intent)
        }

        // Bottom navigation item selection listener
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_delivery -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                    true
                }
                R.id.navigation_live -> {
                    startActivity(Intent(this, LiveActivity::class.java))
                    finish()
                    true
                }
                else -> false
            }
        }
    }
}
