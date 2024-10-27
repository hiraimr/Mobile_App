package com.example.myapplication5

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication5.databinding.ActivityFiltersBinding

class FiltersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFiltersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFiltersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set initial fragment to SortFragment
        loadFragment(SortFragment(), "SortFragment")

        // Button click listeners to switch between fragments
        binding.sortButton.setOnClickListener {
            loadFragment(SortFragment(), "SortFragment")
        }

        binding.cuisinesButton.setOnClickListener {
            loadFragment(CuisinesFragment(), "CuisinesFragment")
        }

        binding.ratingButton.setOnClickListener {
            loadFragment(RatingFragment(), "RatingFragment")
        }

        binding.costForTwoButton.setOnClickListener {
            loadFragment(CostForTwoFragment(), "CostForTwoFragment")
        }

        binding.moreFiltersButton.setOnClickListener {
            loadFragment(MoreFiltersFragment(), "MoreFiltersFragment")
        }

        // Apply Filters button logic
        binding.applyFiltersButton.setOnClickListener {
            val selectedSortOption = (supportFragmentManager.findFragmentByTag("SortFragment") as? SortFragment)?.getSelectedSortOption() ?: "Relevance"
            val selectedCuisines = (supportFragmentManager.findFragmentByTag("CuisinesFragment") as? CuisinesFragment)?.getSelectedCuisines() ?: emptyList()
            val selectedRating = (supportFragmentManager.findFragmentByTag("RatingFragment") as? RatingFragment)?.getSelectedRating() ?: 0.0f

            val intent = Intent(this, DiningActivity::class.java).apply {
                putExtra("SORT_OPTION", selectedSortOption)
                putStringArrayListExtra("CUISINES", ArrayList(selectedCuisines))
                putExtra("SELECTED_RATING", selectedRating)
            }

            startActivity(intent)
            finish()
        }
    }

    // Function to load fragments
    private fun loadFragment(fragment: Fragment, tag: String) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.filters_fragment_container, fragment, tag)
        transaction.commit()
    }
}
