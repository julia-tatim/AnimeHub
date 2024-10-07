package com.example.animehub

import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeAPI {
    @GET("/anime/{id}")
    suspend fun getAnimeById(@Path("id") id: Int): infoAnime

}