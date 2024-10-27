package com.example.myapplication5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication5.databinding.FragmentRatingBinding

class RatingFragment : Fragment() {

    private lateinit var binding: FragmentRatingBinding
    private var selectedRating: Float = 0.0f

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRatingBinding.inflate(inflater, container, false)

        // Set the slider change listener to get selected rating value
        binding.ratingSlider.addOnChangeListener { slider, value, _ ->
            selectedRating = value
            binding.selectedRatingText.text = "$selectedRating+"
        }

        return binding.root
    }

    // Function to return the selected rating when filters are applied
    fun getSelectedRating(): Float {
        return selectedRating
    }
}
