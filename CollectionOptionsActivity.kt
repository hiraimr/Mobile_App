package com.example.myapplication5

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CollectionOptionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collections)

        // Set up back button
        val backButton: ImageView = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            finish() // Close the activity on back button click
        }

        // Set up tabs
        val tabDelivery: TextView = findViewById(R.id.tabDelivery)
        val tabDining: TextView = findViewById(R.id.tabDining)

        tabDelivery.setOnClickListener {
            // Update tab colors and perform any actions if needed
            tabDelivery.setTextColor(resources.getColor(android.R.color.black))
            tabDining.setTextColor(resources.getColor(android.R.color.darker_gray))
            Toast.makeText(this, "Delivery Tab Selected", Toast.LENGTH_SHORT).show()
        }

        tabDining.setOnClickListener {
            // Update tab colors and perform any actions if needed
            tabDining.setTextColor(resources.getColor(android.R.color.black))
            tabDelivery.setTextColor(resources.getColor(android.R.color.darker_gray))
            Toast.makeText(this, "Dining Tab Selected", Toast.LENGTH_SHORT).show()
        }

        // Set up collection cards
        val createCollectionCard: LinearLayout = findViewById(R.id.createCollectionCard)
        createCollectionCard.setOnClickListener {
            Toast.makeText(this, "Create a new Collection", Toast.LENGTH_SHORT).show()
            // Implement functionality to create a new collection
        }
    }
}