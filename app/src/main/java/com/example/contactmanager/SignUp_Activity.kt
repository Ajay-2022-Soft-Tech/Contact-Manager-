package com.example.contactmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUp_Activity : AppCompatActivity() {

    lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up2)

        val userName1 = findViewById<TextInputEditText>(R.id.userName)
        val email1 =findViewById<TextInputEditText>(R.id.email)
        val phoneNo1 = findViewById<TextInputEditText>(R.id.phoneNo)
        val btnSignUpUnder = findViewById<Button>(R.id.btnSignUpUnder)
        val tVSignIn = findViewById<TextView>(R.id.tVSignIn)

        tVSignIn.setOnClickListener {
            val newScreen = Intent (this,SignIn::class.java)
            startActivity(newScreen)
        }

        btnSignUpUnder.setOnClickListener {

            val userName = userName1.text.toString()
            val email = email1.text.toString()
            val phoneNo = phoneNo1.text.toString()

            val user = SignUpUser(userName, email, phoneNo)
            database = FirebaseDatabase.getInstance().getReference("SignUpUser")

            database.child(phoneNo).setValue(user).addOnSuccessListener {
                userName1.text?.clear()
                email1.text?.clear()
                phoneNo1.text?.clear()
            Toast.makeText(this, "Registered",Toast.LENGTH_SHORT).show()
            }.addOnFailureListener{
                Toast.makeText(this, "Failed to Registered",Toast.LENGTH_SHORT).show()

            }



        }



    }
}