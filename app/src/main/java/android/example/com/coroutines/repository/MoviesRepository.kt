package android.example.com.coroutines.repository

import android.arch.lifecycle.LiveData
import android.example.com.coroutines.di.MoviesRoomDbService
import android.example.com.coroutines.di.TheMovieDbService
import android.example.com.coroutines.repository.local.UpcomingMovieRoomEntity
import android.util.Log
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch

object MoviesRepository {
    val TAG = MoviesRepository::class.java.simpleName
    fun getUpcomingMovies(): LiveData<List<UpcomingMovieRoomEntity>> {
        launch(CommonPool) {
            Log.d(TAG, "FETCHING NEW UPCOMING MOVIES")
            try {
                TheMovieDbService.getUpcomingMovies().await().results.forEach {
                    MoviesRoomDbService.upComingMoviesDao.insert(UpcomingMovieRoomEntity.create(it))
                }
            } catch (e: Throwable){
                Log.d(TAG, "$e")
            }
        }
        Log.d(TAG, "RETURNING UPCOMING MOVIES FROM DB")
        return MoviesRoomDbService.upComingMoviesDao.getAllUpcomingMovies()
    }
}