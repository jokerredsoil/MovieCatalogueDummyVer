package com.septian.moviecataloguedummyver.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.septian.moviecataloguedummyver.R
import com.septian.moviecataloguedummyver.data.MovieEntity
import com.septian.moviecataloguedummyver.databinding.ActivityDetailMovieBinding
import com.septian.moviecataloguedummyver.databinding.ContentDetailMovieBinding

class DetailMovieActivity : AppCompatActivity() {

    private lateinit var contentDetailMovieBinding: ContentDetailMovieBinding


    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        contentDetailMovieBinding = binding.detailContent
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val adapter = DetailMovieAdapter()

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getInt(EXTRA_MOVIE)
            viewModel.setSelectedMovies(movieId)
            adapter.setDetail(crew = null)
            this.populateMovie(viewModel.getMovies())

        }
        with(contentDetailMovieBinding.rvDetailCrew) {
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            this.adapter = adapter
            val dividerItemDecoration =
                DividerItemDecoration(this.context, DividerItemDecoration.HORIZONTAL)
            addItemDecoration(dividerItemDecoration)
        }

    }


    private fun populateMovie(movies: MovieEntity) {
        contentDetailMovieBinding.tvTitle.text = movies.movieTitle
        contentDetailMovieBinding.tvReleaseDate.text = movies.movieRelease
        contentDetailMovieBinding.tvRatingItem.text = movies.movieRating
        contentDetailMovieBinding.tvDescription.text = movies.movieDescription

        Glide.with(applicationContext)
            .load(movies.moviePoster)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(contentDetailMovieBinding.ivPoster)

        Glide.with(applicationContext)
            .load(movies.moviePoster)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(contentDetailMovieBinding.ivPosterBackground)

        contentDetailMovieBinding.btnTrailer.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(movies.movieTrailer))
            startActivity(intent)
        }

    }


}
