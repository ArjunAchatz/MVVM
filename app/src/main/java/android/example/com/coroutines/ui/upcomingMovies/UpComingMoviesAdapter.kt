package android.example.com.coroutines.ui.upcomingMovies

import android.example.com.coroutines.databinding.ListItemUpcomingMovieBinding
import android.example.com.coroutines.repository.local.UpcomingMovieRoomEntity
import android.example.com.coroutines.util.BaseDiffUtils
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class UpComingMoviesAdapter(private val upcomingMoviesList: MutableList<UpcomingMovieRoomEntity>)
    : RecyclerView.Adapter<UpComingMoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpComingMoviesViewHolder {
        return UpComingMoviesViewHolder(
                ListItemUpcomingMovieBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount() = upcomingMoviesList.size

    override fun onBindViewHolder(holder: UpComingMoviesViewHolder, position: Int) {
        holder.onBind(upcomingMoviesList[position])
    }

    fun swapItems(newUpcomingMoviesList: List<UpcomingMovieRoomEntity>){
        val diffUtils = UpcomingMoviesDiffUtils(upcomingMoviesList, newUpcomingMoviesList)
        val diffResult = DiffUtil.calculateDiff(diffUtils)
        upcomingMoviesList.clear()
        upcomingMoviesList.addAll(newUpcomingMoviesList)
        diffResult.dispatchUpdatesTo(this)
    }

    class UpcomingMoviesDiffUtils(oldUpcomingMoviesList: List<UpcomingMovieRoomEntity>,
                                  newUpcomingMoviesList: List<UpcomingMovieRoomEntity>)
        : BaseDiffUtils<UpcomingMovieRoomEntity>(oldUpcomingMoviesList, newUpcomingMoviesList){

        override fun areIdsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }
    }
}