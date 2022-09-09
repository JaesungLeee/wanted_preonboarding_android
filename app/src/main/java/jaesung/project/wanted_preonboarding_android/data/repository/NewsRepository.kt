package jaesung.project.wanted_preonboarding_android.data.repository

import jaesung.project.wanted_preonboarding_android.data.datasource.remote.NewsRemoteDataSourceImpl
import jaesung.project.wanted_preonboarding_android.data.model.Article
import jaesung.project.wanted_preonboarding_android.data.model.ResponseWrapper

class NewsRepository(private val dataSource: NewsRemoteDataSourceImpl) {
    suspend fun getHeadlineNews(category: String?): ResponseWrapper<List<Article>> {
        return dataSource.getTopHeadlineNews(category)
    }
}