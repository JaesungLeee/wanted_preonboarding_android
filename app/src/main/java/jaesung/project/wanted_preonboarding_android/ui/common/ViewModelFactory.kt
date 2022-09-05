package jaesung.project.wanted_preonboarding_android.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import jaesung.project.wanted_preonboarding_android.data.datasource.remote.NewsRemoteDataSourceImpl
import jaesung.project.wanted_preonboarding_android.data.network.RetrofitBuilder
import jaesung.project.wanted_preonboarding_android.data.repository.NewsRepository
import jaesung.project.wanted_preonboarding_android.ui.news.NewsViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(NewsViewModel::class.java) -> {
                val apiService = RetrofitBuilder.create()
                val dataSource = NewsRemoteDataSourceImpl(apiService)
                val repository = NewsRepository(dataSource)
                NewsViewModel(repository) as T
            }
            else -> throw IllegalArgumentException("ViewModel 생성 실패 : ${modelClass.name}")
        }
    }
}