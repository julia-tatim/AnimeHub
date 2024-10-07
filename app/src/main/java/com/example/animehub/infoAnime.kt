package com.example.animehub

import android.media.Image

data class infoAnime (
    val image: Image,
    val japTitle: String,
    val engTitle: String,
    val synopsis: String,
    val year: Int,
    val episodes: Int,
    val status: String,
    val type: String,
    val genres: String )
