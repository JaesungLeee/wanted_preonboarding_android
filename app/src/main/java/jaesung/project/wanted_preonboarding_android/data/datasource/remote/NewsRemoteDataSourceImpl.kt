package jaesung.project.wanted_preonboarding_android.data.datasource.remote

import jaesung.project.wanted_preonboarding_android.data.datasource.source.NewsDataSource
import jaesung.project.wanted_preonboarding_android.data.model.Article
import jaesung.project.wanted_preonboarding_android.data.network.NewsService
import jaesung.project.wanted_preonboarding_android.util.ResponseWrapper

class NewsRemoteDataSourceImpl(private val apiService: NewsService) : NewsDataSource {
    override suspend fun getBBCTopHeadlineNews(source: String): ResponseWrapper<List<Article>> {
        return apiService.getBBCTopHeadlineNews(source)
    }
}