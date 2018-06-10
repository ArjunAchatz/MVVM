package android.example.com.coroutines.di

import android.arch.persistence.room.Room
import android.content.Context
import android.example.com.coroutines.repository.local.MoviesRoomDb
import android.example.com.coroutines.repository.local.UpcomingMovieDao

object MoviesRoomDbService {

    lateinit var moviesRoomDb: MoviesRoomDb

    fun init(context: Context) {
        moviesRoomDb =
                Room.databaseBuilder(context, MoviesRoomDb::class.java, "moviesdb.sqlite")
                        .build()
    }

    val upComingMoviesDao: UpcomingMovieDao
        get() = moviesRoomDb.getUpcomingMoviesDao()

}