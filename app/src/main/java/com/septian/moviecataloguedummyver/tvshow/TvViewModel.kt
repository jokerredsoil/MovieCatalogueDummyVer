package com.septian.moviecataloguedummyver.tvshow

import androidx.lifecycle.ViewModel
import com.septian.moviecataloguedummyver.data.TvEntity
import com.septian.moviecataloguedummyver.util.DataDummy

class TvViewModel : ViewModel() {
    val getTvShow : List<TvEntity> = DataDummy.generateTvShow()



}