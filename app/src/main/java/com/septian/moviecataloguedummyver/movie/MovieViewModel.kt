package com.septian.moviecataloguedummyver.movie

import androidx.lifecycle.ViewModel
import com.septian.moviecataloguedummyver.data.MovieEntity
import com.septian.moviecataloguedummyver.data.TvEntity
import com.septian.moviecataloguedummyver.util.DataDummy

class MovieViewModel : ViewModel() {
    val getMovies : List<MovieEntity> = DataDummy.generateMovies()



}