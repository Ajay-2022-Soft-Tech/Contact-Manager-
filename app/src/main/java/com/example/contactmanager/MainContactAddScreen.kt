package com.example.contactmanager

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainContactAddScreen : AppCompatActivity() {

    lateinit var dialog :Dialog
    lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_contact_add_screen)

        val btnAddContact = findViewById<Button>(R.id.btnAddContact)
        val personName = findViewById<TextInputEditText>(R.id.personName)
        val contact = findViewById<TextInputEditText>(R.id.contactNo)
        val alternateContact = findViewById<TextInputEditText>(R.id.alternateContact)
        val homeAddress =  findViewById<TextInputEditText>(R.id.homeAddress)

        dialog = Dialog(this)
        dialog.setContentView(R.layout.customlayout)
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.bg_alert_box))

        var buttonClose = dialog.findViewById<Button>(R.id.buttonClose)

        buttonClose.setOnClickListener{
            dialog.dismiss()
        }


        btnAddContact.setOnClickListener{
            val userName = personName.text.toString()
            val contacts = contact.text.toString()
            val altContact = alternateContact.text.toString()
            val address = homeAddress.text.toString()

            val user = addTocontacts(userName, contacts, altContact, address)
            database = FirebaseDatabase.getInstance().getReference("Contacts")

            database.child(contacts).setValue(user).addOnSuccessListener {
                personName.text?.clear()
                contact.text?.clear()
                alternateContact.text?.clear()
                homeAddress.text?.clear()

                Toast.makeText(this, "Contacts Saved", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener{
                Toast.makeText(this, "Failed to Saved", Toast.LENGTH_SHORT).show()
            }

            dialog.show()
        }
    }
}