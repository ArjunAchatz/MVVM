package android.example.com.coroutines.util

import android.databinding.BindingAdapter
import android.example.com.coroutines.repository.local.UpcomingMovieRoomEntity
import android.example.com.coroutines.ui.upcomingMovies.UpComingMoviesAdapter
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.ProgressBar

@BindingAdapter("app:setList")
fun setList(recyclerView: RecyclerView, upcomingMovies: List<UpcomingMovieRoomEntity>?) {
    val adapter = recyclerView.adapter

    if (adapter is UpComingMoviesAdapter) {
        upcomingMovies?.let { adapter.swapItems(it) }
    }
}

@BindingAdapter("app:isLoading")
fun isLoading(progressBar: ProgressBar, isLoading: Boolean){
    Log.d("DATABINDING UTIL", "isLoading ? $isLoading")
    progressBar.visibility = if(isLoading) View.VISIBLE else View.GONE
}