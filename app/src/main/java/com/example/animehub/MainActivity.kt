package com.example.animehub

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val textButton = findViewById<TextView>(R.id.text_button)
        val loginButton = findViewById<Button>(R.id.login_button) // Botão para LoginActivity

        // Navegar para a página de cadastro
        textButton.setOnClickListener {
            val intent = Intent(this, cadastroact::class.java)
            startActivity(intent)
        }

        // Navegar para a página de login
        loginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
