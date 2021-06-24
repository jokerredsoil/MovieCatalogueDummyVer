package com.septian.moviecataloguedummyver.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.septian.moviecataloguedummyver.databinding.FragmentTvBinding

class TvFragment : Fragment() {

    private var _binding: FragmentTvBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTvBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val viewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            )[TvViewModel::class.java]
            val tvShow = viewModel.getTvShow

            val tvAdapter = TvAdapter()
            tvAdapter.setTv(tvShow)
            with(binding) {
                rvTvShow.layoutManager = LinearLayoutManager(context)
                rvTvShow.setHasFixedSize(true)
                rvTvShow.adapter = tvAdapter
            }
        }
    }
}