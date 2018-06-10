package android.example.com.coroutines.repository.entity

data class UpcomingMovieReponse(
        var results: List<UpcomingMovie> = ArrayList(),
        var page: Int = 0,
        var totalResults: Int = 0,
        var dates: UpcomingMovieDates? = null,
        var totalPages: Int = 0
)

data class UpcomingMovieDates(
        var maximum: String = "",
        var minimum: String = ""
)

data class UpcomingMovie (
        var id: Long? = 0,
        var voteCount: Int? = 0,
        var video: Boolean? = false,
        var voteAverage: Double? = 0.0,
        var title: String? = "",
        var popularity: Double? = null,
        var posterPath: String? = "",
        var originalLanguage: String? = "",
        var originalTitle: String? = "",
        var genreIds: List<Int>? = ArrayList(),
        var backdropPath: String? = "",
        var adult: Boolean? = null,
        var overview: String? = "",
        var releaseDate: String? = ""
)