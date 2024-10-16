package com.example.myapplication5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class PhoneNumberActivity : AppCompatActivity() {
    private lateinit var nextButton: Button
    private lateinit var phoneNumberEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_number) // Make sure this layout exists

        // Initialize views
        nextButton = findViewById(R.id.next_button) // Ensure this ID matches your layout
        phoneNumberEditText = findViewById(R.id.phone_number_edit_text) // Ensure this ID matches your layout

        // Set OnClickListener for the Next button
        nextButton.setOnClickListener {
            navigateToHome() // Navigate to HomeActivity
        }
    }

    private fun navigateToHome() {
        val intent = Intent(this, HomeActivity::class.java) // Ensure HomeActivity is the correct class
        startActivity(intent)
        finish() // Close PhoneNumberActivity to prevent going back
    }
}
