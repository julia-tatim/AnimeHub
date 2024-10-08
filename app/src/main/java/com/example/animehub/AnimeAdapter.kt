import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.animehub.Anime
import com.example.animehub.databinding.ActivityHomeBinding

class AnimeAdapter(private val animes: List<Anime>) : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ActivityHomeBinding.inflate(layoutInflater, parent, false)
        return AnimeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.bind(animes[position])
    }

    override fun getItemCount(): Int = animes.size
    fun updateData(animes: List<Anime>?) {
        (animes as MutableList).clear()
        val newAnimes = null
        animes.addAll(newAnimes)
        notifyDataSetChanged()
    }

    @BindingAdapter("imageUrl")
    fun loadImage(view: ImageView, url: String?) {
        Glide.with(view.context)
            .load(url)
            .into(view)
    }

    inner class AnimeViewHolder(private val binding: ActivityHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(anime: Anime) {
            binding.anime = anime //id do componente do layout
            binding.executePendingBindings()
        }
    }
}


