package com.septian.moviecataloguedummyver.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.septian.moviecataloguedummyver.R
import com.septian.moviecataloguedummyver.data.TvEntity
import com.septian.moviecataloguedummyver.databinding.ItemListBinding
import com.septian.moviecataloguedummyver.detail.DetailTvActivity

class TvAdapter : RecyclerView.Adapter<TvAdapter.TvViewHolder>() {

    private var listTv = ArrayList<TvEntity>()

    fun setTv(tvShows: List<TvEntity>?) {
        if (tvShows == null) return
        this.listTv.clear()
        this.listTv.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        val itemListBinding =
            ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvViewHolder(itemListBinding)
    }

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        val tvShow = listTv[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = listTv.size

    class TvViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvEntity: TvEntity) {
            with(binding) {
                tvItemTitle.text = tvEntity.tvShowTitle
                tvItemDate.text = tvEntity.tvShowRelease
                tvRatingItem.text = tvEntity.tvShowRating.plus("%")
                Glide.with(itemView.context)
                    .load(tvEntity.tvShowPoster)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvActivity::class.java)
                    intent.putExtra(DetailTvActivity.EXTRA_SHOW, tvEntity.tvShowId)
                    itemView.context.startActivity(intent)
                }
            }
        }

    }
}