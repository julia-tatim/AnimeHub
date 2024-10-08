package com.example.animehub

import AnimeAdapter
import AnimeViewModel
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.animehub.databinding.ActivityHomeBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Home : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding

    private val animeViewModel: AnimeViewModel by viewModels()
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.jikan.moe/v4/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val api = retrofit.create(JikanApiService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home)
        binding.viewModel = animeViewModel
        binding.lifecycleOwner = this

        val adapter = AnimeAdapter(emptyList())
        binding.recyclerView.adapter = adapter

        animeViewModel.animeList.observe(this, Observer { animes ->
            adapter.updateData(animes)
        })

        binding.perfilIcon.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
    }
}