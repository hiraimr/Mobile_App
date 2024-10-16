package com.example.myapplication5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login) // Ensure this layout exists

        val phoneNumberInput: EditText = findViewById(R.id.phone_number_input) // Match this ID
        val continueButton: Button = findViewById(R.id.continue_button) // Match this ID

        continueButton.setOnClickListener {
            val phoneNumber = phoneNumberInput.text.toString()
            if (phoneNumber.isNotEmpty()) {
                // Show a message
                Toast.makeText(this, "Phone Number: $phoneNumber", Toast.LENGTH_SHORT).show()

                // Navigate to HomeActivity after entering the phone number
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish() // Close LoginActivity
            } else {
                Toast.makeText(this, "Please enter your phone number", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
