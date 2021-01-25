package com.andre.basquete

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        register_button_register.setOnClickListener {
            performRegister()
        }

        //Ir para a página de login
        haveAccount_textView.setOnClickListener {
            //redirecionar para a página de login
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }

    private fun performRegister() {
        register_button_register.setOnClickListener {

            val email = email_editText_register.text.toString()
            val password = password_editText_register.text.toString()

            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Enter text in all fields", Toast.LENGTH_SHORT ).show()
                return@setOnClickListener
            }

            Log.d("caralho", "email: $email")
            Log.d("caralho", "pass: $password")

            //Firebase Authentication
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if(!it.isSuccessful) return@addOnCompleteListener
                    }
                    .addOnFailureListener{
                        Log.d("Main", "Failed to create user: ${it.message}")
                        Toast.makeText(this, "Failed to create user: ${it.message}", Toast.LENGTH_SHORT ).show()
                    }

        }
    }

}
