package com.example.animehub

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animehub.databinding.ActivityHomeBinding
import com.example.animehub.databinding.ActivityLoginBinding
import com.example.animehub.databinding.ActivityMainBinding

class Home : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home)
        binding.ViewMostView.adapter = AnimeAdapter()
        /*binding.ViewMostView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))*/
        binding.ViewMostView.layoutManager = LinearLayoutManager(this)

        binding.perfilIcon.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }




    }
}