package com.example.animehub

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        // Associa o ImageButton ao ID do layout
        val backButton = findViewById<ImageButton>(R.id.back_button)

        // Define o comportamento de voltar para a tela anterior
        backButton.setOnClickListener {
            finish() // Encerra a atividade atual e volta para a anterior
        }
    }
}
