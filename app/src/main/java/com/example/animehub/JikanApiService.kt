package com.example.animehub

import retrofit2.http.GET
import retrofit2.Call

interface JikanApiService {
    @GET("anime")
    fun getAnimeList(): Call<AnimeResponse>
}