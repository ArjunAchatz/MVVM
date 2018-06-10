package android.example.com.coroutines.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.example.com.coroutines.repository.MoviesRepository
import android.example.com.coroutines.repository.local.UpcomingMovieRoomEntity

class UpcomingMoviesViewModel : ViewModel() {

    val upcomingMovies: LiveData<List<UpcomingMovieRoomEntity>>?
        get() {
            return data ?: refresh()
        }

    val isLoading = MutableLiveData<Boolean>()
    val displayDetails = MutableLiveData<UpcomingMovieRoomEntity>()

    fun refresh(): LiveData<List<UpcomingMovieRoomEntity>>? {
        isLoading.value = true
        data = MoviesRepository.getUpcomingMovies()
        isLoading.value = false
        return data
    }

    fun displayDetails(upcomingMovieRoomEntity: UpcomingMovieRoomEntity){
        displayDetails.value = upcomingMovieRoomEntity
    }

    private var data: LiveData<List<UpcomingMovieRoomEntity>>? = null

}