package com.septian.moviecataloguedummyver.movie

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MovieViewModelTest {
    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp(){
        viewModel = MovieViewModel()
    }

    @Test
    fun getGetMovies() {
        val movieEntities = viewModel.getMovies
        assertNotNull(movieEntities)
        assertEquals(19,movieEntities.size)
    }
}