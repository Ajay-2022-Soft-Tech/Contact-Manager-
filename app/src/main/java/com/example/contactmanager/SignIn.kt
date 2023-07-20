package com.example.contactmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignIn : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference

    companion object {
        const val KEY1 = "com.example.contactmanager.SignIn.userName"
        const val KEY2 = "com.example.contactmanager.SignIn.email"
        const val KEY3 = "com.example.contactmanager.SignIn.phoneNO"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val phoneNumber1 = findViewById<TextInputEditText>(R.id.phoneNumber)
        val email1 = findViewById<TextInputEditText>(R.id.emailID)
        val btnSignIn = findViewById<Button>(R.id.buttonSignIn)

        btnSignIn.setOnClickListener {
            val phoneNo = phoneNumber1.text.toString()
            val email = email1.text.toString()

            if (phoneNo.isNotEmpty()) {
                readData(phoneNo)
            } else {
                Toast.makeText(this, "Please Enter Phone No.", Toast.LENGTH_SHORT).show()

            }
        }

    }

    private fun readData(phoneNo: String) {

        databaseReference = FirebaseDatabase.getInstance().getReference("SignUpUser")
        databaseReference.child(phoneNo).get().addOnSuccessListener {
            if (it.exists()){
                val userName =it.child("userName").value
                val email = it.child("email").value
                val  phoneNo = it.child("phoneNo").value

//                here we passing the values
                val intentWelcome = Intent (this, WelcomeActivity::class.java)
                intentWelcome.putExtra(KEY1, userName.toString())
                intentWelcome.putExtra(KEY2, email.toString())
                intentWelcome.putExtra(KEY3, phoneNo.toString())
                startActivity(intentWelcome)
            }
            else {
                Toast.makeText(this, "User does not exists", Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener {
            Toast.makeText(this, "Failed , Error in Database", Toast.LENGTH_SHORT).show()
        }

        }
    }
