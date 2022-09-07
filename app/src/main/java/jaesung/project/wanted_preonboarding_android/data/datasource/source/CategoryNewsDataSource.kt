package jaesung.project.wanted_preonboarding_android.data.datasource.source

import jaesung.project.wanted_preonboarding_android.data.model.Article
import jaesung.project.wanted_preonboarding_android.util.ResponseWrapper

interface CategoryNewsDataSource {
    suspend fun loadCategoryNews(category: String): ResponseWrapper<List<Article>>
}