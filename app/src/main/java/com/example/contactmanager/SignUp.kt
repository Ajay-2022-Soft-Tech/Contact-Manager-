package com.example.contactmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val btnSignUp = findViewById<Button>(R.id.bntSignUp)
        btnSignUp.setOnClickListener {
            val newScreen = Intent(this, SignUp_Activity::class.java)
            startActivity(newScreen)
        }

        val btnSignIn = findViewById<Button>(R.id.bntSignIn)
        btnSignIn.setOnClickListener {
            val newScreen = Intent(this, SignIn::class.java)
            startActivity(newScreen)
        }
    }
}