package com.example.hdwalpaper.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hdwalpaper.retrofit.ApiService
import java.lang.IllegalArgumentException

class ViewModelFactory(var category:String,var apiService: ApiService):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AppViewModel::class.java)){
            return AppViewModel(category,apiService) as T
        }else if (modelClass.isAssignableFrom(AppViewModel1::class.java)){
            return AppViewModel1(category,apiService) as T
        }else if (modelClass.isAssignableFrom(AppViewModel2::class.java)){
            return AppViewModel2(category,apiService) as T
        }else if (modelClass.isAssignableFrom(AppViewModel3::class.java)) {
            return AppViewModel3(category, apiService) as T
        }else if (modelClass.isAssignableFrom(AppViewModel4::class.java)) {
            return AppViewModel4(category, apiService) as T
        }else if (modelClass.isAssignableFrom(AppViewModel5::class.java)) {
            return AppViewModel5(category, apiService) as T
        }else if (modelClass.isAssignableFrom(AppViewModel6::class.java)) {
            return AppViewModel6(category, apiService) as T
        }else  if (modelClass.isAssignableFrom(AppViewModel7::class.java)) {
            return AppViewModel7(category, apiService) as T
        }else  if (modelClass.isAssignableFrom(AppViewModel8::class.java)) {
            return AppViewModel8(category, apiService) as T
        }else  if (modelClass.isAssignableFrom(AppViewModel9::class.java)) {
            return AppViewModel9(category, apiService) as T
        }else  if (modelClass.isAssignableFrom(AppViewModel10::class.java)) {
            return AppViewModel10(category, apiService) as T
        }
        throw IllegalArgumentException("Error Factory")
    }

}