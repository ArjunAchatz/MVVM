package android.example.com.coroutines.repository.remote

import android.example.com.coroutines.repository.entity.UpcomingMovieReponse
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET


interface TheMovieDbAPI {

    companion object {
        const val API_KEY = "f691bdcc172ce8691bc2790b96b8c61a"
        const val UPCOMING_MOVIES_END_POINT  = "movie/upcoming"
    }

    @GET("$UPCOMING_MOVIES_END_POINT?api_key=$API_KEY&language=en-US")
    fun getUpcomingMovies() : Deferred<UpcomingMovieReponse>
}