package android.example.com.coroutines.ui.upcomingMovies

import android.example.com.coroutines.databinding.ListItemUpcomingMovieBinding
import android.example.com.coroutines.repository.local.UpcomingMovieRoomEntity
import android.support.v7.widget.RecyclerView

class UpComingMoviesViewHolder(val viewBinding: ListItemUpcomingMovieBinding)
    : RecyclerView.ViewHolder(viewBinding.root) {
    fun onBind(upcomingMovieRoomEntity: UpcomingMovieRoomEntity) {
        viewBinding.upcomingMovie = upcomingMovieRoomEntity
    }
}