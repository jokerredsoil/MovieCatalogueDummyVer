package com.septian.moviecataloguedummyver.tvshow

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TvViewModelTest {
    private lateinit var viewModel: TvViewModel

    @Before
    fun setUp() {
        viewModel = TvViewModel()
    }

    @Test
    fun getGetTvShow() {
        val tvShowEntities = viewModel.getTvShow
        assertNotNull(tvShowEntities)
        assertEquals(20,tvShowEntities.size)
    }
}