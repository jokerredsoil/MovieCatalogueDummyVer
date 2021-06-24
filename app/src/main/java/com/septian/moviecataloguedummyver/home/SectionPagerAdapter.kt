package com.septian.moviecataloguedummyver.home

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.septian.moviecataloguedummyver.R
import com.septian.moviecataloguedummyver.movie.MovieFragment
import com.septian.moviecataloguedummyver.tvshow.TvFragment

@Suppress("DEPRECATION")
class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    companion object {

        private val TAB_TITLES = intArrayOf(R.string.movies, R.string.tvshow)
    }

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> MovieFragment()
            1 -> TvFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence =
        mContext.resources.getString(TAB_TITLES[position])

    override fun getCount(): Int = 2
}