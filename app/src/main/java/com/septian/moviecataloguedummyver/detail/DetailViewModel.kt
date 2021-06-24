package com.septian.moviecataloguedummyver.detail

import androidx.lifecycle.ViewModel
import com.septian.moviecataloguedummyver.data.MovieEntity
import com.septian.moviecataloguedummyver.data.TvEntity
import com.septian.moviecataloguedummyver.util.DataDummy
import kotlin.properties.Delegates

class DetailViewModel : ViewModel() {
    private var movieId by Delegates.notNull<Int>()
    private var tvShowId by Delegates.notNull<Int>()

    fun setSelectedMovies(movieId: Int) {
        this.movieId = movieId
    }

    fun getMovies(): MovieEntity {
        lateinit var movie: MovieEntity
        val movieEntities = DataDummy.generateMovies()
        for (movieEntity in movieEntities) {
            if (movieEntity.movieId == movieId) {
                movie = movieEntity
            }
        }
        return movie
    }


    fun setSelectedTvShow(tvShowId: Int) {
        this.tvShowId = tvShowId
    }

    fun getTv(): TvEntity {
        lateinit var tvShow: TvEntity
        val tvEntities = DataDummy.generateTvShow()
        for (tvEntity in tvEntities) {
            if (tvEntity.tvShowId == tvShowId) {
                tvShow = tvEntity
            }
        }
        return tvShow
    }


}