package android.example.com.coroutines.util

import android.databinding.BindingAdapter
import android.example.com.coroutines.viewmodel.UpcomingMoviesViewModel
import android.support.v7.widget.RecyclerView
import android.util.Log

@BindingAdapter("app:setList")
fun setList(recyclerView: RecyclerView, upcomingMoviesViewModel: UpcomingMoviesViewModel){
    Log.d("ADAPTER", "HIT WITH $recyclerView and model contains ${upcomingMoviesViewModel.upcomingMovies?.value?.size}")
}