import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.animehub.Anime
import com.example.animehub.AnimeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnimeViewModel : ViewModel() {

    private val _animeList = MutableLiveData<List<Anime>>()
    val animeList: LiveData<List<Anime>> get() = _animeList

    init {
        fetchAnimeList()
    }

    private fun fetchAnimeList() {
        RetrofitClient.instance.getTopAnimes().enqueue(object : Callback<AnimeResponse> {
            override fun onResponse(call: Call<AnimeResponse>, response: Response<AnimeResponse>) {
                if (response.isSuccessful) {
                    _animeList.postValue(response.body()?.top)
                }
            }

            override fun onFailure(call: Call<AnimeResponse>, t: Throwable) {
                // Tratar erro
            }
        })
    }
}


