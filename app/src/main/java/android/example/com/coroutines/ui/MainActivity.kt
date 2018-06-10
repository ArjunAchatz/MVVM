package android.example.com.coroutines.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.example.com.coroutines.R
import android.example.com.coroutines.databinding.ActivityMainBinding
import android.example.com.coroutines.repository.local.UpcomingMovieRoomEntity
import android.example.com.coroutines.ui.upcomingMovies.UpComingMoviesAdapter
import android.example.com.coroutines.viewmodel.UpcomingMoviesViewModel
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val upcomingMoviesViewModel = ViewModelProviders
                .of(this@MainActivity)
                .get(UpcomingMoviesViewModel::class.java)

        upcomingMoviesViewModel
                .displayDetails
                .observe(this, Observer<UpcomingMovieRoomEntity> {
                    it?.releaseDate?.let { releaseDate ->
                        Toast.makeText(this, "Release date : $releaseDate", Toast.LENGTH_LONG)
                                .show()
                    }
                })

        DataBindingUtil
                .setContentView<ActivityMainBinding>(this, R.layout.activity_main)
                .apply {
                    setLifecycleOwner(this@MainActivity)
                    listOfUpcomingMovies = upcomingMoviesViewModel
                    upcomingMoviesRecyclerview.adapter = UpComingMoviesAdapter(
                            mutableListOf(), upcomingMoviesViewModel)
                }
    }

}
