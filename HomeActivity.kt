package com.example.myapplication5

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.Task

class HomeActivity : AppCompatActivity() {
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home) // Ensure this layout exists

        // Initialize the FusedLocationProviderClient
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        // UI elements
        val locationIcon: ImageView = findViewById(R.id.location_icon)
        val locationTextView: TextView = findViewById(R.id.location_text)
        val cityTextView: TextView = findViewById(R.id.city_text)
        val searchInput: EditText = findViewById(R.id.search_input)
        val exploreButton: Button = findViewById(R.id.explore_options_button)

        // Set location and city (modify as needed)
        locationTextView.text = "Your Location" // Default text
        cityTextView.text = "City" // Replace with actual city

        // Set up click listener for the location icon
        locationIcon.setOnClickListener {
            // Check for location permission
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)
            } else {
                // Fetch the user's location
                getLocation()
            }
        }

        // Set up click listener for the explore button
        exploreButton.setOnClickListener {
            val intent = Intent(this, ExploreOptionsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getLocation() {
        val task: Task<Location> = fusedLocationClient.lastLocation
        task.addOnSuccessListener { location: Location? ->
            if (location != null) {
                // Get the latitude and longitude
                val latitude = location.latitude
                val longitude = location.longitude
                // Update the location text view
                findViewById<TextView>(R.id.location_text).text = "Lat: $latitude, Lon: $longitude"
                Toast.makeText(this, "Location: Lat: $latitude, Lon: $longitude", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Unable to retrieve location", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Handle permission result
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, fetch location
                getLocation()
            } else {
                Toast.makeText(this, "Location permission denied", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
