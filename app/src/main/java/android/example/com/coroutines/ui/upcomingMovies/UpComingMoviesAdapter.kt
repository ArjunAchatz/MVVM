package android.example.com.coroutines.ui.upcomingMovies

import android.example.com.coroutines.databinding.ListItemUpcomingMovieBinding
import android.example.com.coroutines.repository.local.UpcomingMovieRoomEntity
import android.example.com.coroutines.util.BaseDiffUtils
import android.example.com.coroutines.viewmodel.UpcomingMoviesViewModel
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

class UpComingMoviesAdapter(
        private val upcomingMoviesList: MutableList<UpcomingMovieRoomEntity>,
        private val upcomingMoviesViewModel: UpcomingMoviesViewModel
)
    : RecyclerView.Adapter<UpComingMoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpComingMoviesViewHolder {
        return UpComingMoviesViewHolder(
                ListItemUpcomingMovieBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount() = upcomingMoviesList.size

    override fun onBindViewHolder(holder: UpComingMoviesViewHolder, position: Int) {
        holder.onBind(upcomingMoviesList[position], upcomingMoviesViewModel)
    }

    fun swapItems(newUpcomingMoviesList: List<UpcomingMovieRoomEntity>){
        launch(UI) {
            val diffUtils = UpcomingMoviesDiffUtils(upcomingMoviesList, newUpcomingMoviesList)
            val diffResult = DiffUtil.calculateDiff(diffUtils)
            upcomingMoviesList.clear()
            upcomingMoviesList.addAll(newUpcomingMoviesList)
            diffResult.dispatchUpdatesTo(this@UpComingMoviesAdapter)
            upcomingMoviesViewModel.isLoading.value = false
        }
    }

    class UpcomingMoviesDiffUtils(oldUpcomingMoviesList: List<UpcomingMovieRoomEntity>,
                                  newUpcomingMoviesList: List<UpcomingMovieRoomEntity>)
        : BaseDiffUtils<UpcomingMovieRoomEntity>(oldUpcomingMoviesList, newUpcomingMoviesList){

        override fun areIdsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }
    }
}