package com.example.myapplication5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.myapplication5.databinding.FragmentCuisinesBinding

class CuisinesFragment : Fragment() {

    private lateinit var binding: FragmentCuisinesBinding
    private val selectedCuisines = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCuisinesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // List of cuisines
        val cuisines = listOf(
            "Afghan", "American", "Andhra", "Arabian", "Asian", "Bakery",
            "Bar Food", "Bengali", "Biryani", "Cafe", "Chinese", "Continental",
            "Desserts", "European", "Fast Food", "French", "Greek", "Indian",
            "Italian", "Japanese", "Korean", "Lebanese", "Mexican", "North Indian",
            "Pizza", "Seafood", "South Indian", "Spanish", "Thai", "Turkish"
        )

        // Setup ListView and adapter
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_multiple_choice, cuisines)
        binding.cuisinesListView.adapter = adapter
        binding.cuisinesListView.choiceMode = android.widget.ListView.CHOICE_MODE_MULTIPLE

        // Implement search functionality
        binding.cuisineSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return true
            }
        })

        // Handle item clicks to add/remove selected cuisines
        binding.cuisinesListView.setOnItemClickListener { _, _, position, _ ->
            val selectedCuisine = adapter.getItem(position) ?: return@setOnItemClickListener
            if (selectedCuisines.contains(selectedCuisine)) {
                selectedCuisines.remove(selectedCuisine)
            } else {
                selectedCuisines.add(selectedCuisine)
            }
        }
    }

    // Function to get selected cuisines
    fun getSelectedCuisines(): List<String> {
        return selectedCuisines
    }
}
