package android.example.com.coroutines.di

import android.example.com.coroutines.repository.entity.UpcomingMovieReponse
import android.example.com.coroutines.repository.remote.TheMovieDbAPI
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import kotlinx.coroutines.experimental.Deferred
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TheMovieDbApiService {

    private val theMovieDbAPI: TheMovieDbAPI = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(TheMovieDbAPI::class.java)

    fun getUpcomingMovies(): Deferred<UpcomingMovieReponse> {
        return theMovieDbAPI.getUpcomingMovies()
    }

}