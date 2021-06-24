package com.septian.moviecataloguedummyver.data


class MovieEntity(
    val movieId: Int?,
    val movieTitle: String?,
    val movieDescription: String?,
    val moviePoster: Int?,
    val movieRelease: String?,
    val movieRating: String,
    val movieTrailer: String?,
    val featuredCrew: List<FeaturedCrew>

)