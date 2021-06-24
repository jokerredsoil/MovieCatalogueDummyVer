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
import com.septian.moviecataloguedummyver.data.TvEntity
import com.septian.moviecataloguedummyver.databinding.ActivityDetailTvBinding
import com.septian.moviecataloguedummyver.databinding.ContentDetailMovieBinding

class DetailTvActivity : AppCompatActivity() {
    private lateinit var detailContentDetailMovieBinding: ContentDetailMovieBinding

    companion object {
        const val EXTRA_SHOW = "extra_show"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailTvBinding.inflate(layoutInflater)
        detailContentDetailMovieBinding = binding.detailContent
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
            val tvShowId = extras.getInt(EXTRA_SHOW)
            viewModel.setSelectedTvShow(tvShowId)
            adapter.setDetail(crew = arrayListOf())
            populateTvShow(viewModel.getTv())
        }
        with(detailContentDetailMovieBinding.rvDetailCrew) {
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            this.adapter = adapter
            val dividerItemDecoration =
                DividerItemDecoration(
                    this.context,
                    DividerItemDecoration.HORIZONTAL
                )
            addItemDecoration(dividerItemDecoration)
        }


    }

    private fun populateTvShow(tvEntity: TvEntity) {
        detailContentDetailMovieBinding.tvTitle.text = tvEntity.tvShowTitle
        detailContentDetailMovieBinding.tvReleaseDate.text = tvEntity.tvShowRelease
        detailContentDetailMovieBinding.tvRatingItem.text = tvEntity.tvShowRating
        detailContentDetailMovieBinding.tvDescription.text = tvEntity.tvShowDescription

        Glide.with(applicationContext)
            .load(tvEntity.tvShowPoster)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(detailContentDetailMovieBinding.ivPoster)

        Glide.with(applicationContext)
            .load(tvEntity.tvShowPoster)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(detailContentDetailMovieBinding.ivPosterBackground)

        detailContentDetailMovieBinding.btnTrailer.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(tvEntity.tvShowTrailer))
            startActivity(intent)
        }
    }
}