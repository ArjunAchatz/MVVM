package android.example.com.coroutines.repository.local

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import android.example.com.coroutines.repository.entity.BaseDao

@Dao
interface UpcomingMovieDao: BaseDao<UpcomingMovieRoomEntity> {

    @Query("SELECT * FROM $UPCOMING_MOVIE_TABLE")
    fun getAllUpcomingMovies(): LiveData<List<UpcomingMovieRoomEntity>>
}