package android.example.com.coroutines.repository.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase


@Database(entities = arrayOf(UpcomingMovieRoomEntity::class), version = 1)
abstract class MoviesRoomDb : RoomDatabase() {
    abstract fun getUpcomingMoviesDao(): UpcomingMovieDao
}