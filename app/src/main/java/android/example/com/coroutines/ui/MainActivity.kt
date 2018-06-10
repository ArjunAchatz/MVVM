package android.example.com.coroutines.ui

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.example.com.coroutines.R
import android.example.com.coroutines.databinding.ActivityMainBinding
import android.example.com.coroutines.ui.upcomingMovies.UpComingMoviesAdapter
import android.example.com.coroutines.viewmodel.UpcomingMoviesViewModel
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil
                .setContentView<ActivityMainBinding>(this, R.layout.activity_main)
                .apply {
                    setLifecycleOwner(this@MainActivity)
                    upcomingMoviesRecyclerview.adapter = UpComingMoviesAdapter(mutableListOf())
                    listOfUpcomingMovies = ViewModelProviders
                            .of(this@MainActivity)
                            .get(UpcomingMoviesViewModel::class.java)
                }
    }

}
