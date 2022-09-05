package jaesung.project.wanted_preonboarding_android.data.datasource.source

import jaesung.project.wanted_preonboarding_android.data.model.Article
import jaesung.project.wanted_preonboarding_android.util.ResponseWrapper

interface NewsDataSource {
    suspend fun getBBCTopHeadlineNews(source: String): ResponseWrapper<List<Article>>
}