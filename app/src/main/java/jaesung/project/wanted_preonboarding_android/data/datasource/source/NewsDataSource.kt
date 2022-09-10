package jaesung.project.wanted_preonboarding_android.data.datasource.source

import jaesung.project.wanted_preonboarding_android.data.model.NewsResponse

interface NewsDataSource {
    suspend fun getHeadlineNews(category: String?): NewsResponse
}