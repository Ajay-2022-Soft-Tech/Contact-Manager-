package com.example.contactmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val verify = findViewById<Button>(R.id.btnVerify)
        val name = intent.getStringExtra(SignIn.KEY1)
        val email = intent.getStringExtra(SignIn.KEY2)
        val phoneNo = intent.getStringExtra(SignIn.KEY3)

        val welcomeText = findViewById<TextView>(R.id.tVWelcome)
        val userName = findViewById<TextView>(R.id.tVName)
        val mail = findViewById<TextView>(R.id.tVEmail)
        val phone = findViewById<TextView>(R.id.tVPhone)
//
        welcomeText.text = "Welcome $name"
        userName.text = "UserName :$name"
        mail.text = "Mail : $email"
        phone.text = "UserId :$phoneNo"



        verify.setOnClickListener{
            val mainContactAddScreen = Intent (this,MainContactAddScreen::class.java )
            startActivity(mainContactAddScreen)

        }
    }
}