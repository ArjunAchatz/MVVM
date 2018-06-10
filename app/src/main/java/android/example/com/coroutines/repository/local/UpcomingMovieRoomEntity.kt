package android.example.com.coroutines.repository.local

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.example.com.coroutines.repository.entity.UpcomingMovie

const val UPCOMING_MOVIE_TABLE = "UPCOMING_MOVIE_TABLE"

@Entity(tableName = UPCOMING_MOVIE_TABLE)
class UpcomingMovieRoomEntity(
        @PrimaryKey(autoGenerate = false)
        var id: Long? = 0,
        var voteCount: Int? = 0,
        var video: Boolean? = false,
        var voteAverage: Double? = 0.0,
        var title: String? = "",
        var popularity: Double? = null,
        var posterPath: String? = "",
        var originalLanguage: String? = "",
        var originalTitle: String? = "",
        var backdropPath: String? = "",
        var adult: Boolean? = null,
        var overview: String? = "",
        var releaseDate: String? = ""
) {
    companion object {
        fun create(upcomingMovie: UpcomingMovie): UpcomingMovieRoomEntity {
            return UpcomingMovieRoomEntity(
                    upcomingMovie.id,
                    upcomingMovie.vote_count,
                    upcomingMovie.video,
                    upcomingMovie.vote_average,
                    upcomingMovie.title,
                    upcomingMovie.popularity,
                    upcomingMovie.poster_path,
                    upcomingMovie.original_language,
                    upcomingMovie.original_title,
                    upcomingMovie.backdrop_path,
                    upcomingMovie.adult,
                    upcomingMovie.overview,
                    upcomingMovie.release_date
            )
        }
    }
}