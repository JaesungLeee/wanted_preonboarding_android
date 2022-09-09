package jaesung.project.wanted_preonboarding_android.data.datasource.remote

import jaesung.project.wanted_preonboarding_android.data.datasource.source.CategoryNewsDataSource
import jaesung.project.wanted_preonboarding_android.data.model.Article
import jaesung.project.wanted_preonboarding_android.data.network.NewsService
import jaesung.project.wanted_preonboarding_android.util.ResponseWrapper

class CategoryNewsRemoteDataSourceImpl(private val apiService: NewsService) : CategoryNewsDataSource {
    override suspend fun loadCategoryNews(category: String): ResponseWrapper<List<Article>> {
        return apiService.getHeadlineNews(category = category)
    }
}