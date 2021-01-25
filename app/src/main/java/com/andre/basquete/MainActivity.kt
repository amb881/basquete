package com.andre.basquete

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val haveAccount: TextView = findViewById(R.id.account_textView) as TextView
        haveAccount.setOnClickListener{
            //abrir página do login
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


    }
}