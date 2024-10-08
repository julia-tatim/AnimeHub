package com.example.animehub

data class AnimeResponse(val data: List<Anime>) {
    val top: List<Anime>?
        get() {
            TODO()
        }
}

data class Anime(
    val id: Int,
    val title: String,
    val synopsis: String,
    val type: String,
    val episodes: Int,
    val image: String
)

data class AnimeImages(
    val jpg: ImageDetails
)

data class ImageDetails(
    val imageUrl: String
)