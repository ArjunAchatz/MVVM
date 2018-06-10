package android.example.com.coroutines

import android.app.Application
import android.example.com.coroutines.di.MoviesRoomDbService

class MoviesApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        MoviesRoomDbService.init(this)
    }
}