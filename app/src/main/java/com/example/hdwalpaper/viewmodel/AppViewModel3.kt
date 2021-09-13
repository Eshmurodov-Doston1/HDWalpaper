package com.example.hdwalpaper.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.hdwalpaper.paging.PagerDataSource
import com.example.hdwalpaper.paging.PagerDataSource1
import com.example.hdwalpaper.paging.PagerDataSource2
import com.example.hdwalpaper.paging.PagerDataSource3
import com.example.hdwalpaper.retrofit.ApiService

class AppViewModel3(var category:String, var apiService: ApiService):ViewModel() {
    var unsplashImage = Pager(PagingConfig(12)){
        PagerDataSource3(category,apiService)
    }.flow.cachedIn(viewModelScope)
}