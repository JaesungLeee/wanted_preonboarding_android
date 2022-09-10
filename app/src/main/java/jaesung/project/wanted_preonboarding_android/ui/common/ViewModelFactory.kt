package jaesung.project.wanted_preonboarding_android.ui.common

import android.content.Context
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return when {
//            modelClass.isAssignableFrom(NewsViewModel::class.java) -> {
//                val apiService = RetrofitBuilder.create()
//                val dataSource = NewsRemoteDataSourceImpl(apiService)
//                val repository = NewsRepositoryImpl(dataSource)
//                NewsViewModel(repository) as T
//            }
//
//            modelClass.isAssignableFrom(CategoryViewModel::class.java) -> {
//                val dataSource = CategoryLocalDataSourceImpl()
//                val repository = CategoryRepositoryImpl(dataSource)
//                CategoryViewModel(repository) as T
//            }
//
//            modelClass.isAssignableFrom(CategoryNewsViewModel::class.java) -> {
//                val apiService = RetrofitBuilder.create()
//                val dataSource = CategoryNewsRemoteDataSourceImpl(apiService)
//                val repository = CategoryNewsRepository(dataSource)
//                CategoryNewsViewModel(repository) as T
//            }
//            else -> throw IllegalArgumentException("ViewModel 생성 실패 : ${modelClass.name}")
//        }
//    }
}