package com.septian.moviecataloguedummyver.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.septian.moviecataloguedummyver.data.FeaturedCrew
import com.septian.moviecataloguedummyver.databinding.ItemCastBinding

class DetailMovieAdapter : RecyclerView.Adapter<DetailMovieAdapter.DetailViewHolder>() {
    private val listCrew = ArrayList<FeaturedCrew>()

    fun setDetail(crew: List<FeaturedCrew>?) {
        if (crew == null) return
        this.listCrew.clear()
        this.listCrew.addAll(crew)
    }

    class DetailViewHolder(private val binding: ItemCastBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(crew: FeaturedCrew) {
            with(binding) {
                tvCrewName.text = crew.crewName
                tvCrewPosition.text = crew.crewPosition

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val itemCastBinding =
            ItemCastBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailViewHolder(itemCastBinding)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val crew = listCrew[position]
        holder.bind(crew)
    }

    override fun getItemCount(): Int = listCrew.size


}
