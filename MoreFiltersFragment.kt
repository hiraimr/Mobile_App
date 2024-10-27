package com.example.myapplication5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import com.example.myapplication5.databinding.FragmentMoreFiltersBinding

class MoreFiltersFragment : Fragment() {

    private var _binding: FragmentMoreFiltersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoreFiltersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getSelectedFilters(): List<String> {
        val selectedFilters = mutableListOf<String>()
        if (binding.checkboxCreditCard.isChecked) selectedFilters.add("Credit Card")
        if (binding.checkboxServesAlcohol.isChecked) selectedFilters.add("Serves Alcohol")
        if (binding.checkboxOpenNow.isChecked) selectedFilters.add("Open Now")
        if (binding.checkboxWifi.isChecked) selectedFilters.add("Wifi")
        if (binding.checkboxOutdoorSeating.isChecked) selectedFilters.add("Outdoor Seating")
        if (binding.checkboxBookTable.isChecked) selectedFilters.add("Book Table")
        if (binding.checkboxVegOnly.isChecked) selectedFilters.add("Veg-only")
        return selectedFilters
    }
}
