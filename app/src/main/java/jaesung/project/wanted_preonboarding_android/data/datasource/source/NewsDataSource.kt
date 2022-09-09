package jaesung.project.wanted_preonboarding_android.data.datasource.source

import jaesung.project.wanted_preonboarding_android.data.model.Article
import jaesung.project.wanted_preonboarding_android.data.model.ResponseWrapper

interface NewsDataSource {
    suspend fun getTopHeadlineNews(category: String?): ResponseWrapper<List<Article>>
}