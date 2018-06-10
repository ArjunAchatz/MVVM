package android.example.com.coroutines.ui.upcomingMovies

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.example.com.coroutines.R
import android.example.com.coroutines.databinding.ActivityMainBinding
import android.example.com.coroutines.databinding.FragmentUpComingMoviesBinding
import android.example.com.coroutines.repository.local.UpcomingMovieRoomEntity
import android.example.com.coroutines.viewmodel.UpcomingMoviesViewModel
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

class UpComingMoviesFragment : Fragment() {

    companion object {
        fun newInstance() = UpComingMoviesFragment()
    }

    lateinit var fragmentViewBinding: FragmentUpComingMoviesBinding

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        fragmentViewBinding = FragmentUpComingMoviesBinding.inflate(layoutInflater, container, false)
        return fragmentViewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val upcomingMoviesViewModel = ViewModelProviders
                .of(this)
                .get(UpcomingMoviesViewModel::class.java)

        upcomingMoviesViewModel
                .displayDetails
                .observe(this, Observer<UpcomingMovieRoomEntity> {
                    it?.releaseDate?.let { releaseDate ->
                        Toast.makeText(
                                context,
                                "Release date : $releaseDate",
                                Toast.LENGTH_LONG)
                                .show()
                    }
                })

        fragmentViewBinding.apply {
                    setLifecycleOwner(this@UpComingMoviesFragment)
                    listOfUpcomingMovies = upcomingMoviesViewModel
                    upcomingMoviesRecyclerview.adapter = UpComingMoviesAdapter(
                            mutableListOf(), upcomingMoviesViewModel)
                }
    }
}
