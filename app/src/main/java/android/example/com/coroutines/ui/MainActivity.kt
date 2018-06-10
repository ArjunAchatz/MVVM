package android.example.com.coroutines.ui

import android.databinding.DataBindingUtil
import android.example.com.coroutines.R
import android.example.com.coroutines.databinding.ActivityMainBinding
import android.example.com.coroutines.ui.upcomingMovies.UpComingMoviesFragment
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil
                .setContentView<ActivityMainBinding>(this, R.layout.activity_main)
                .apply {
                    if (supportFragmentManager.findFragmentByTag(
                                    UpComingMoviesFragment::class.java.canonicalName) == null) {
                        supportFragmentManager
                                .beginTransaction()
                                .add(R.id.fragment_container,
                                        UpComingMoviesFragment.newInstance(),
                                        UpComingMoviesFragment::class.java.canonicalName)
                                .commit()
                    }
                }
    }

}
