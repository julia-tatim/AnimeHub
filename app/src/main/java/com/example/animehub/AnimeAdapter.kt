package com.example.animehub
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.animehub.databinding.HomeCardBinding

class AnimeAdapter :RecyclerView.Adapter<AnimeAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: HomeCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(anime: infoAnime) {
            binding.AnimeTitle.text = anime.japTitle
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = HomeCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        // Retorna o menor valor entre o limite e o tamanho da lista
        return minOf(Singleton.animeList.size, 10)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Singleton.animeList[position].let {
            holder.bind(it)
        }
    }
}