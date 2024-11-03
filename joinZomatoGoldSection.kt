package com.example.myapplication5

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class joinZomatoGoldSection : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_zomato_gold_section)

        // Find the Join Gold button and set up a click listener
        val joinGoldButton: Button = findViewById(R.id.joinGoldButton)
        joinGoldButton.setOnClickListener {
            Toast.makeText(this, "Gold Membership Activated!", Toast.LENGTH_SHORT).show()
            // Add further actions like navigating or enabling features if needed
        }
    }
}