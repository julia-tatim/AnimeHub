package com.example.animehub


import com.example.animehub.Cadastroact
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.databinding.DataBindingUtil
import com.example.animehub.databinding.ActivityMainBinding


class MainActivity : ComponentActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.loginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.signUpButton.setOnClickListener {
            val intent = Intent(
                this,
                Cadastroact::class.java
            )
            startActivity(intent)
        }
    }
}
