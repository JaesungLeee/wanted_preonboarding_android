package jaesung.project.wanted_preonboarding_android.data.repository

import jaesung.project.wanted_preonboarding_android.data.datasource.remote.NewsRemoteDataSourceImpl
import jaesung.project.wanted_preonboarding_android.data.model.Article
import jaesung.project.wanted_preonboarding_android.util.ResponseWrapper

class NewsRepository(private val dataSource: NewsRemoteDataSourceImpl) {
    suspend fun getBBCTopHeadlineNews(source: String): ResponseWrapper<List<Article>> {
        return dataSource.getBBCTopHeadlineNews(source)
    }
}