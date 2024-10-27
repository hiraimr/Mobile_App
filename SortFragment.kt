package com.example.myapplication5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication5.databinding.FragmentSortBinding

class SortFragment : Fragment() {

    private lateinit var binding: FragmentSortBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSortBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Function to retrieve selected sorting option
    fun getSelectedSortOption(): String {
        return when (binding.sortOptions.checkedRadioButtonId) {
            R.id.sort_by_relevance -> "Relevance"
            R.id.sort_by_rating -> "Rating: High to Low"
            R.id.sort_by_offer -> "Offer: High to Low"
            R.id.sort_by_price_low_to_high -> "Cost: Low to High"
            R.id.sort_by_price_high_to_low -> "Cost: High to Low"
            R.id.sort_by_distance -> "Distance: Low to High"
            else -> "Relevance"
        }
    }
}
