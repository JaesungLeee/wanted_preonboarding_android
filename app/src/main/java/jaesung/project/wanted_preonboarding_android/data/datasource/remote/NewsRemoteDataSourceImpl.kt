package jaesung.project.wanted_preonboarding_android.data.datasource.remote

import jaesung.project.wanted_preonboarding_android.data.datasource.source.NewsDataSource
import jaesung.project.wanted_preonboarding_android.data.model.Article
import jaesung.project.wanted_preonboarding_android.data.model.NewsResponse
import jaesung.project.wanted_preonboarding_android.data.network.NewsService

class NewsRemoteDataSourceImpl(private val apiService: NewsService) : NewsDataSource {
    override suspend fun getHeadlineNews(category: String?): NewsResponse {
        return apiService.getHeadlineNews(category = category)
    }
}