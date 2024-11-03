package com.example.myapplication5

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        // Initialize views
        val userNameTextView: TextView = findViewById(R.id.tv_user_name)
        val followInfoTextView: TextView = findViewById(R.id.tv_follow_info)
        val addPhotoButton: Button = findViewById(R.id.btn_add_photo)
        val editProfileButton: Button = findViewById(R.id.btn_edit_profile)

        // Set user information
        userNameTextView.text = "Hira Bhatti"
        followInfoTextView.text = "0 followers • 0 following"

        // Handle button clicks
        addPhotoButton.setOnClickListener {
            // TODO: Add functionality to add a photo
        }

        editProfileButton.setOnClickListener {
            // TODO: Add functionality to edit profile
        }
    }
}
