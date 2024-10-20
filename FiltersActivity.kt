//package com.example.myapplication5
//
//import android.content.Intent
//import android.os.Bundle
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import com.example.myapplication5.databinding.ActivityFiltersBinding
//
//class FiltersActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityFiltersBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityFiltersBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        // Setup actions on filter options
//        setupFilters()
//    }
//
//    private fun setupFilters() {
//        // Apply Filters button logic
//        binding.applyFiltersButton.setOnClickListener {
//            // Retrieve the selected filter and sorting options
//            val selectedSortOption = when (binding.sortOptions.checkedRadioButtonId) {
//                R.id.sort_by_relevance -> "Relevance"
//                R.id.sort_by_rating -> "Rating"
//                R.id.sort_by_price -> "Price"
//                else -> "Relevance"
//            }
//
//            // Toast message showing the selected option
//            Toast.makeText(this, "Sorting by: $selectedSortOption", Toast.LENGTH_SHORT).show()
//
//            // Intent back to DiningActivity with the selected filters
//            val intent = Intent(this, DiningActivity::class.java)
//            intent.putExtra("SORT_OPTION", selectedSortOption)
//
//            // Optionally, you can add more filter values
//            // intent.putExtra("ANOTHER_FILTER", value)
//
//            startActivity(intent)
//            finish()
//        }
//
//        // Additional sorting logic or click actions if needed
//    }
//}

package com.example.myapplication5

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication5.databinding.ActivityFiltersBinding

class FiltersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFiltersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFiltersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup actions on filter options
        setupFilters()
    }

    private fun setupFilters() {
        // Apply Filters button logic
        binding.applyFiltersButton.setOnClickListener {
            // Retrieve the selected filter and sorting options
            val selectedSortOption = when (binding.sortOptions.checkedRadioButtonId) {
                R.id.sort_by_relevance -> "Relevance"
                R.id.sort_by_rating -> "Rating: High to Low"
                R.id.sort_by_offer -> "Offer: High to Low"
                R.id.sort_by_price_low_to_high -> "Cost: Low to High"
                R.id.sort_by_price_high_to_low -> "Cost: High to Low"
                R.id.sort_by_distance -> "Distance: Low to High"
                else -> "Relevance"
            }

            // Toast message showing the selected option
            Toast.makeText(this, "Sorting by: $selectedSortOption", Toast.LENGTH_SHORT).show()

            // Intent back to DiningActivity with the selected filters
            val intent = Intent(this, DiningActivity::class.java)
            intent.putExtra("SORT_OPTION", selectedSortOption)

            // Optionally, you can add more filter values here

            startActivity(intent)
            finish()
        }

        // Clear All button logic
        binding.clearAllButton.setOnClickListener {
            // Clear all filter selections by resetting the RadioGroup
            binding.sortOptions.clearCheck()

            // Show a message confirming the action
            Toast.makeText(this, "Filters cleared", Toast.LENGTH_SHORT).show()
        }
    }
}

