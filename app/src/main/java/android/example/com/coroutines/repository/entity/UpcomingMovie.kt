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
        var vote_count: Int? = 0,
        var id: Long? = 0,
        var video: Boolean? = false,
        var vote_average: Double? = 0.0,
        var title: String? = "",
        var popularity: Double? = null,
        var poster_path: String? = "",
        var original_language: String? = "",
        var original_title: String? = "",
        var genre_ids: List<Int>? = ArrayList(),
        var backdrop_path: String? = "",
        var adult: Boolean? = null,
        var overview: String? = "",
        var release_date: String? = ""
)