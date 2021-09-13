package com.example.hdwalpaper.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.hdwalpaper.retrofit.ApiService
import java.lang.Exception

class PagerDataSource2(var category: String, var apiServise: ApiService):PagingSource<Int,com.example.hdwalpaper.models.Result>() {
    override fun getRefreshKey(state: PagingState<Int, com.example.hdwalpaper.models.Result>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, com.example.hdwalpaper.models.Result> {
      try {
          val number = params.key?:1
          val image = apiServise.getImage1(category,number)
          if (number>1){
              return LoadResult.Page(image.results,number-1,number+1)
          }else{
              return LoadResult.Page(image.results,null,number+1)
          }
      }catch (e:Exception){
          return LoadResult.Error(e)
      }
    }

}