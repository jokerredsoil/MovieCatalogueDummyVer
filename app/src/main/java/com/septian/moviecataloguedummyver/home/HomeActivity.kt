package com.septian.moviecataloguedummyver.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.septian.moviecataloguedummyver.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        binding.viewPager.adapter = sectionsPagerAdapter
        binding.tabs.setupWithViewPager(binding.viewPager)


        supportActionBar?.elevation = 0f
    }
}