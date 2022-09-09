package jaesung.project.wanted_preonboarding_android.data.datasource.remote

import jaesung.project.wanted_preonboarding_android.data.datasource.source.NewsDataSource
import jaesung.project.wanted_preonboarding_android.data.model.Article
import jaesung.project.wanted_preonboarding_android.data.network.NewsService
import jaesung.project.wanted_preonboarding_android.data.model.ResponseWrapper

class NewsRemoteDataSourceImpl(private val apiService: NewsService) : NewsDataSource {
    override suspend fun getTopHeadlineNews(category: String?): ResponseWrapper<List<Article>> {
        return apiService.getHeadlineNews(category = category)
    }
}