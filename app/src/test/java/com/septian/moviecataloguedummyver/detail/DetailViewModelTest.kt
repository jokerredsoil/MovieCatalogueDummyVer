package com.septian.moviecataloguedummyver.detail

import com.septian.moviecataloguedummyver.util.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel

    private val dummyMovie = DataDummy.generateMovies()[0]
    private val movieId = dummyMovie.movieId
    private val dummyTvShow = DataDummy.generateTvShow()[0]
    private val tvShowId = dummyTvShow.tvShowId

    @Before
    fun setUp() {
        viewModel = DetailViewModel()

        movieId?.let { viewModel.setSelectedMovies(it) }

        if (tvShowId != null) {
            viewModel.setSelectedTvShow(tvShowId)
        }

    }


    @Test
    fun getMovies() {
        viewModel.setSelectedMovies(dummyMovie.movieId!!)
        val movieEntity = viewModel.getMovies()
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.movieId, movieEntity.movieId)
        assertEquals(dummyMovie.movieTitle, movieEntity.movieTitle)
        assertEquals(dummyMovie.movieRelease, movieEntity.movieRelease)
        assertEquals(dummyMovie.moviePoster, movieEntity.moviePoster)
        assertEquals(dummyMovie.movieRating, movieEntity.movieRating)
        assertEquals(dummyMovie.movieDescription, movieEntity.movieDescription)
        assertEquals(dummyMovie.movieTrailer, movieEntity.movieTrailer)
    }


    @Test
    fun getTv() {
        viewModel.setSelectedTvShow(dummyTvShow.tvShowId!!)
        val tvEntity = viewModel.getTv()
        assertNotNull(tvEntity)
        assertEquals(dummyTvShow.tvShowId, tvEntity.tvShowId)
        assertEquals(dummyTvShow.tvShowTitle, tvEntity.tvShowTitle)
        assertEquals(dummyTvShow.tvShowRelease, tvEntity.tvShowRelease)
        assertEquals(dummyTvShow.tvShowPoster, tvEntity.tvShowPoster)
        assertEquals(dummyTvShow.tvShowRating, tvEntity.tvShowRating)
        assertEquals(dummyTvShow.tvShowDescription, tvEntity.tvShowDescription)
        assertEquals(dummyTvShow.tvShowTrailer, tvEntity.tvShowTrailer)
    }

    @Test
    fun setSelectedMovies() {
        val movieEntities = viewModel.getMovies()
        assertNotNull(movieEntities)
        assertEquals(1,movieEntities.movieId)
    }

    @Test
    fun setSelectedTvShow() {
        val tvShowEntities = viewModel.getTv()
        assertNotNull(tvShowEntities)
        assertEquals(21,tvShowEntities.tvShowId)
    }
}