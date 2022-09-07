package jaesung.project.wanted_preonboarding_android.data.repository

import jaesung.project.wanted_preonboarding_android.data.datasource.remote.CategoryNewsRemoteDataSourceImpl
import jaesung.project.wanted_preonboarding_android.data.model.Article
import jaesung.project.wanted_preonboarding_android.util.ResponseWrapper

class CategoryNewsRepository(private val dataSource: CategoryNewsRemoteDataSourceImpl) {

    suspend fun loadCategoryNews(category: String) : ResponseWrapper<List<Article>> {
        return dataSource.loadCategoryNews(category)
    }
}